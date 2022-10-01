package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userDao;
import model.User;

/**
 * Servlet implementation class user_login
 */
@WebServlet("/user_login")
public class user_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		if(email != null) {
			String password = request.getParameter("password");
			System.out.println(email+"\t"+password);
			userDao udao = new userDao();
			User u = udao.Login(email, password);
			HttpSession hs = request.getSession(true);
			if(u != null) {
				boolean chk_evs = udao.check_evs(email);
				if(chk_evs) {
					hs.setAttribute("User", u);
					response.sendRedirect("dashboard.jsp");
				}else {
					hs.setAttribute("evs_fail", email);
					response.sendRedirect("login.jsp");
				}
			}else {
				hs.setAttribute("invalid_credentials", "Invalid Credentials..!!");
				response.sendRedirect("login.jsp");
			}
		}else {
			response.sendRedirect("login.jsp");
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
