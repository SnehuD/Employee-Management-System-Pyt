package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Email_Sender;

/**
 * Servlet implementation class send_email
 */
@WebServlet("/send_email")
public class send_email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public send_email() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from = request.getParameter("from");
		if(from != null) {
			String to = request.getParameter("to");
			String subject = request.getParameter("subject");
			String body = request.getParameter("body");
			Email_Sender es = new Email_Sender();
			HttpSession hs = request.getSession(true);
			int send_status = es.send_email(from, to, subject, body);
			if(send_status == 1) {
				hs.setAttribute("email_sent", "Email Sent successfully");
			}else {
				hs.setAttribute("email_not_sent", "Something went wrong while sending the Email");
			}
		}
		response.sendRedirect("dashboard.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
