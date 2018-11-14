package com.exam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.DAO.StudentDAO;

@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StudentLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String aadhar = request.getParameter("aadhar");
		String name = request.getParameter("name");

		System.out.println("Inside Servlet");
		System.out.println("Aadhar: " + aadhar);
		System.out.println("Name: " + name);

		if (StudentDAO.validateStudentLogin(aadhar, name)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("name", name);
			System.out.println("Inside if");
			RequestDispatcher rs = request.getRequestDispatcher("/Welcome.jsp");
			rs.forward(request, response);
			//response.sendRedirect(request.getSession().getServletContext().getRealPath("/Welcome.jsp"));
		} else {
			System.out.println("Inside else");
			System.out.println("Incorrect aadhar and name");
			RequestDispatcher rs = request.getRequestDispatcher("/Login.html");
			rs.forward(request, response);
		}
		
	}

}
