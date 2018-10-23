package com.exam.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.exam.DBConnect.DBConnect;

public class CourseDAO {

	public static boolean insertCourse(String course, String mark, String duration) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection con = null;
		try{
			con = DBConnect.getConnection();
			String query = "INSERT into course(courseName,totalMarks,time) values(?,?,?)";
			
			//insert data using PreparedStatement
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, course);
			ps.setString(2, mark);
			ps.setString(3, duration);
			
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
