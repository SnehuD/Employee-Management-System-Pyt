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
 * Servlet implementation class forgot_password
 */
@WebServlet("/forgot_password")
public class forgot_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgot_password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getParameter("email");
		if(email != null) {
			HttpSession hs = request.getSession(true);
			userDao udao = new userDao();
			boolean check_evs = udao.check_evs(email);
			if(check_evs == true) {
				String pass = udao.getPass(email);
				if(pass != null) {
					hs.setAttribute("pass_sent", "Password sent to your registered email");
					response.sendRedirect("login.jsp");
				}
			}else {
				hs.setAttribute("evs_fail", email);
				response.sendRedirect("login.jsp");
			}
			
		}else {
			response.sendRedirect("forgot-password.jsp");
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
