package com.cruds.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		
		String action = request.getParameter("ACTION");
		
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(true);

		if("logout".equals(action))
		{
			session.invalidate();// session destroy
			rd = request.getRequestDispatcher("login.jsp");
		}
		else
		{
			if(userId.equals("admin") && pwd.equals("secret"))
			{
				request.setAttribute("MESSAGE", "Hello, Welcome");
				//request.setAttribute("USERID", userId);
				session.setAttribute("USERID", userId);
				rd = request.getRequestDispatcher("welcome.jsp");
			}
			else
			{
				rd = request.getRequestDispatcher("login.jsp");
			}
		}
		
		rd.forward(request, response);
	}

}
