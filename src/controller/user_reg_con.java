package controller;

import java.io.IOException;
import java.util.Random;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userDao;
import model.User;

/**
 * Servlet implementation class user_reg_con
 */
@WebServlet("/user_reg_con")
public class user_reg_con extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public user_reg_con() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		if(fname != null) {
			
			HttpSession hs = request.getSession(true);
			hs.setAttribute("Register_controller", "Active");
			
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(fname+"\t"+lname+"\t"+email+"\t"+password);
			userDao udao = new userDao();			
			boolean is_email_exist = udao.email_exist(email);	// checks if email is exist or not		
			if(!is_email_exist) {
				Random rand = new Random();
				int token = 100000 + (int)(rand.nextFloat() * 899900);
				User u = new User(fname, lname, email, password, String.valueOf(token));
				int reg_status = udao.reg_user(u);
				if(reg_status > 0) {
					hs.setAttribute("reg_status", "Registered Successfully\nVerification Link Sent to Your Email.");
				}
			}else {
				System.out.println("Email ID Already Exist");
				hs.setAttribute("email_exist", "Email ID Already Exist");
			}
			response.sendRedirect("register.jsp");
		}else {
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
