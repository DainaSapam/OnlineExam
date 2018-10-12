package com.exam.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.exam.DBConnect.DBConnect;

public class QuestionsDAO {

	public static boolean insertQuestions(String question, String opt1,
			String opt2, String opt3, String opt4, String answer) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection con = null;
		try{
			con = DBConnect.getConnection();
			String query = "INSERT into questions(question,opt1,opt2,opt3,opt4,correctanswer) values(?,?,?,?,?,?)";
			
			//insert data using PreparedStatement
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, question);
			ps.setString(2, opt1);
			ps.setString(3, opt2);
			ps.setString(4, opt3);
			ps.setString(5, opt4);
			ps.setString(6, answer);
			
			ps.execute();
			flag = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con != null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

}
