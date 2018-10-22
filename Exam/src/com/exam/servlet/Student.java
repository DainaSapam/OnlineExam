package com.exam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.DAO.StudentDAO;

@WebServlet("/Student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String aadhar = request.getParameter("aadhar");
		String name = request.getParameter("name");
		
		System.out.println("Student servlet");
		
		System.out.println("Aadhar Number: "+aadhar);
		System.out.println("Name: "+name);
		
		if(StudentDAO.insertStudents(aadhar, name)){
			System.out.println("Students successfully inserted into the database");
			response.sendRedirect("AddStudent.jsp");
		}else{
			System.out.println("Unable to insert the question ");
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
