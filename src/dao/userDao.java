package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.verifyemail;
import model.User;
import model.Email_Sender;

public class userDao {
	Connection con = null; 
	PreparedStatement ps = null;
	Database db = new Database();
	Email_Sender ES = new Email_Sender();
	
	// Register User
	public int reg_user(User u) {
		con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into user (fname, lname, email, password, token, evs, reg_time) values (?, ?, ?, ?, ?, 'Inactive',  CURRENT_TIME)");
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPasswd());
			ps.setString(5, u.getToken());
			int i = ps.executeUpdate();
			if(i > 0) {
				i = ES.sendVEmail("Hii "+u.getFname()+"\nThanks for Registering with Email Sending System..!", "http://localhost:8081/ESS/verifyemail?email="+u.getEmail()+"&token="+u.getToken(), "Email Sending System [Email Verification]", u.getEmail(), "v");
				return i;
			}
		} catch(Exception e){
			System.out.println(e);
		}
		return 0;
	}
	
	// check if email is exist or not
	public boolean email_exist(String email) {
		boolean i = false;
		con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select email from user where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {							
				if(rs.getString(1).equals(email)) {
					i = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	// Login User with correct credentials
	public User Login(String email, String password) {
		User u = null;
		con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select *from user where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				u.setEvs(rs.getString(6));
				u.setReg_time(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	// Email Verify
	public boolean verify_email(String email,String token) {
		boolean ver = false;
		con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select email, token from user where email = ? and token = ?");
			ps.setString(1, email);
			ps.setString(2, token);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
					if(rs.getString(1).equals(email) && rs.getString(2).equals(token)) {
						ver = true;
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ver;
	}
	
	// Email Verified....
	public int email_verified(String email) {
		con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update user set evs = 'Active' where email = ?");
			ps.setString(1, email);
			int i = ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;		
	}
	
	// check if Email is Verified ot not
	public boolean check_evs(String email) {
		boolean chk_evs = false;
		con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select evs from user where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals("Active")) {
					chk_evs = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chk_evs;
	}
	
	// Send Email verification link
	public int sevl(String email) {
		int s = 0;
		con = db.getConnection();		
		try {
			PreparedStatement ps = con.prepareStatement("select email, token from user where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String vlink = "http://localhost:8081/ESS/verifyemail?email="+rs.getString(1)+"&token="+rs.getString(2);
				s = ES.sendVEmail("Hello Dear !! Thanks For Registering With Email Sending System.", vlink, "[Email Sending System] : Email Verification", rs.getString(1), "v");
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	// get token by email for resend email verification link
	public String getToken(String email) {
		String token = null;
		con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select token from user wher eemail= ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				token = rs.getString(1);
				return token;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;		
	}
	
	// get the password by Email
	public String getPass(String email) {
		String pass = null;
		con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select password from user where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pass = rs.getString(1);
				ES.sendVEmail("Hii "+email+",<br>", pass, "[Email Sending System] Forgot Password", email, "fp");
				return pass;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pass;
	}
	
}