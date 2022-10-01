package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userDao;

/**
 * Servlet implementation class verifyemail
 */
@WebServlet("/verifyemail")
public class verifyemail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifyemail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		if(email != null) {
			String token = request.getParameter("token");
			userDao udao = new userDao();
			boolean verification = udao.verify_email(email, token);
			HttpSession hs = request.getSession(true);
			if(verification) {
				udao.email_verified(email);
//				System.out.println("Email Verified Successfully");
				hs.setAttribute("email_verified", "Email Verified Successfully..");
			}else {
				hs.setAttribute("not_email_verified", "Email ID Not Verified");
			}
			response.sendRedirect("login.jsp");
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
