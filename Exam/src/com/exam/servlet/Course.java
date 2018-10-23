package com.exam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.DAO.CourseDAO;

@WebServlet("/Course")
public class Course extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Course() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String course = request.getParameter("course");
		String marks = request.getParameter("marks");
		String duration = request.getParameter("duration"); 
		
		System.out.println("Course Servlet");
		
		System.out.println("Course Name: "+course);
		System.out.println("Total Marks: "+marks);
		System.out.println("Duration: "+duration);
		
		if(CourseDAO.insertCourse(course, marks, duration)){
			System.out.println("Course successfully inserted into the database");
			response.sendRedirect("course.jsp");
		}else{
			System.out.println("Unable to insert the course ");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
