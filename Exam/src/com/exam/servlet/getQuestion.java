package com.exam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.DAO.QuestionsDAO;

@WebServlet("/getQuestion")
public class getQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getQuestion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		String question_no = request.getParameter("qNo");
		HttpSession session = request.getSession(true);;
		String name = (String) session.getAttribute("name");
		System.out.println("Question No: "+question_no);
		System.out.println("Name: "+name);
		
		String question = QuestionsDAO.getQuestion(question_no);
		System.out.println(question);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
