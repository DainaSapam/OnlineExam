package com.exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.DAO.LoginValidate;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("Inside Servlet");
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);

		if (LoginValidate.validateUserLogin(username, password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", username);
			System.out.println("Inside if");
			RequestDispatcher rs = request
					.getRequestDispatcher("Dashboard.jsp");
			rs.forward(request, response);
		} else {
			System.out.println("Inside else");
			out.println("Incorrect username and password");
			RequestDispatcher rs = request.getRequestDispatcher("AdminLogin.html");
			rs.forward(request, response);
		}
	}

}
