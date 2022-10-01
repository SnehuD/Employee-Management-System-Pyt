package model;

public class User {
	String fname = null;
	String lname = null;
	String email = null;
	String passwd = null;
	String token = null;
	String evs = null;
	String reg_time = null; 
	
	public User(String fname, String lname, String email, String passwd, String token) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.passwd = passwd;
		this.token = token;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEvs() {
		return evs;
	}

	public void setEvs(String evs) {
		this.evs = evs;
	}

	public String getReg_time() {
		return reg_time;
	}

	public void setReg_time(String reg_time) {
		this.reg_time = reg_time;
	}

}
