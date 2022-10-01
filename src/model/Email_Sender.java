package model;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email_Sender {

	public int sendVEmail(String message,String content, String subject, String to,String t) {
//		System.out.println(message+content+subject+to+t);
		int i = 0;
		String from = "services.propad@gmail.com";
		//Variable for gmail
		String host="smtp.gmail.com";

		//get the system properties
		Properties properties = System.getProperties();

		//setting important information to properties object

		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback", "false");

		//Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("services.propad@gmail.com", "Propad@1234");
			}
		});
		session.setDebug(true);

		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);

		try {

			//from email
			m.setFrom(new InternetAddress(from));

			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			//adding subject to message
			m.setSubject(subject);

			//adding text to message
			m.setText(message);
			String dflt = "<html>"
					+ "<body>"
					+ "<div style='background: linear-gradient(to right, #00fc93, #56ffda, #a1f3d4);" +
					"        width: 50%;" + 
					"        margin: auto;" + 
					"        border: 5px solid aquamarine;" + 
					"        text-align: center;'>"+ 
					" 		<h2 style='text-align: center;" + 
					"        background-image: linear-gradient(to left, rgb(5, 255, 180), indigo, blue, green, rgb(226, 44, 31), orange, red);" + 
					"        -webkit-background-clip: text;" + 
					"        -webkit-text-fill-color: transparent;" + 
					"        text-decoration: underline;color:white'>"
					+ 		"Welcome to Email Sending System</h2>"
					+ 		" <hr>"
					+ 		"<p style='font-weight: bold;'>"+message;			
			if(t.equals("v")) {
				m.setContent(dflt+" To Verify Your Email Click Verify Email<br><br> <a href='"+content+"'>"
					+ 		"<button style='background: linear-gradient(to right, #2e4e41, #922fb1, #f80b9d);\r\n" + 
					"        padding: 5px;" + 
					"        border: 5px solid aqua;" + 
					"        border-radius: 30px;" + 
					"        cursor: pointer;" + 
					"        font-size: 15px;"
					+ 		"color:white"
					+ "'>Verify Email</button></a></p>"
					+ "</div></body></html>", "text/html");
			}
			else if(t.equals("fp")) {
				m.setContent(dflt+" You were requested for forgot password<br>Here is Your Password..<br>"
					+ 		"<button style='background: linear-gradient(to right, #2e4e41, #922fb1, #f80b9d);\r\n" + 
					"        padding: 5px;" +
					"        border: 5px solid aqua;" +
					"        border-radius: 30px;" +
					"        cursor: pointer;" +
					"        font-size: 15px;"
					+ 		"color:white"
					+ "'>"+content+"</button></p>"
					+ "</div></body></html>", "text/html");
			}
			Transport.send(m);
			System.out.println("Email Verification Email Sent Success");
			i = 1;
		}catch (Exception e) {
			e.printStackTrace();
			i = 0;
		}
		return i;
	}
	public int send_email(String from, String to, String subject, String body) {
		int i = 0;
//		String from = "services.propad@gmail.com";
		//Variable for gmail
		String host="smtp.gmail.com";

		//get the system properties
		Properties properties = System.getProperties();

		//setting important information to properties object

		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback", "false");

		//Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("services.propad@gmail.com", "Propad@1234");
			}
		});
		session.setDebug(true);

		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);

		try {

			//from email
			m.setFrom(new InternetAddress(from));

			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			//adding subject to message
			m.setSubject(subject);

			//adding text to message
			m.setText(from+ " Sent this Email to you by using Email Sending System\n\n"+ body);
			Transport.send(m);
			System.out.println("Email Sent Success");
			i = 1;
		}catch (Exception e) {
			e.printStackTrace();
			i = 0;
		}
		return i;			
	}
}