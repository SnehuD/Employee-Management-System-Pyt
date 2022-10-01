package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	public Connection getConnection() {		
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/email_sending_system","root","");  
			// here Email_Sending_System is database name, root is username and password is blank
		}catch(Exception e){
			System.out.println("Connection Error");
		}
		return con;
	}
}