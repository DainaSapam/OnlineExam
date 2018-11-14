package com.exam.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;

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
			
		}catch(SQLException e){
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
	
	public static String getQuestion(String questionNo){
		
		String query = "select * from questions order by random() limit 1";
		
		Connection con = null;
		
		JSONObject obj = new JSONObject();
		
		try{
			con = DBConnect.getConnection();
			
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				obj.put("qNo",questionNo);
				obj.put("qID",rs.getInt("question_id"));
				obj.put("question",rs.getString("question"));
				obj.put("opt1",rs.getString("opt1"));
				obj.put("opt2",rs.getString("opt2"));
				obj.put("opt3",rs.getString("opt3"));
				obj.put("opt4",rs.getString("opt4"));
				obj.put("answer",rs.getString("correctAnswer"));
			}
			
			ps.close();
			rs.close();
		}catch(SQLException e){
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
		
		return obj.toString();
	}
	
	public static String getPreviousQuestion(String questionID){
		
		System.out.println(questionID);
		String query = "select * from questions where question_id="+questionID;
		
		Connection con = null;
		
		JSONObject obj = new JSONObject();
		
		try{
			con = DBConnect.getConnection();
			System.out.println(query);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				obj.put("qId",questionID);
				obj.put("question",rs.getString("question"));
				obj.put("opt1",rs.getString("opt1"));
				obj.put("opt2",rs.getString("opt2"));
				obj.put("opt3",rs.getString("opt3"));
				obj.put("opt4",rs.getString("opt4"));
				obj.put("answer",rs.getString("correctAnswer"));
			}
			
			ps.close();
			rs.close();
		}catch(SQLException e){
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
		
		return obj.toString();
		
	}

}
