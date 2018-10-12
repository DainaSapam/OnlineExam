package com.exam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.DAO.QuestionsDAO;

/**
 * Servlet implementation class Questions
 */
@WebServlet("/Questions")
public class Questions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Questions() {
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
		
		/*response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");*/
		String question = request.getParameter("question");
		String opt1 = request.getParameter("opt1");
		String opt2 = request.getParameter("opt2");
		String opt3 = request.getParameter("opt3");
		String opt4 = request.getParameter("opt4");
		String answer = request.getParameter("answer");
		
		System.out.println("Inside Questions servlet");
		
		System.out.println("Question: "+question);
		System.out.println("Option 1: "+opt1);
		System.out.println("Option 2: "+opt2);
		System.out.println("Option 3: "+opt3);
		System.out.println("Option 4: "+opt4);
		System.out.println("Answer: "+answer);
		
		if(QuestionsDAO.insertQuestions(question, opt1, opt2, opt3, opt4, answer)){
			System.out.println("Question successfully inserted into the database");
			response.sendRedirect("question.jsp");
		}else{
			System.out.println("Unable to insert the question ");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
