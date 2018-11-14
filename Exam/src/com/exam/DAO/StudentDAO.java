package com.exam.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.exam.DBConnect.DBConnect;

public class StudentDAO {
	
	public static boolean insertStudents(String aadhar, String name, String batch, int courseID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection con = null;
		try{
			con = DBConnect.getConnection();
			String query = "INSERT into student(aadharNumber,studentName,batch,course) values(?,?,?,?)";
			
			//insert data using PreparedStatement
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, aadhar);
			ps.setString(2, name);
			ps.setString(3, batch);
			ps.setInt(4, courseID);
			
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
	
	public static boolean validateStudentLogin(String aadhar, String name){
		  boolean flag = false;		  
		  Connection con = null;
		  try{
		   con = DBConnect.getConnection();
		   if(con != null){
		    Statement stat = con.createStatement();
		    String qry = "SELECT * FROM public.student WHERE aadharNumber = '"+aadhar+"' AND studentName = '"+name+"'";
		    ResultSet rs = stat.executeQuery(qry);
		    if(rs.next()){
		     flag = true;
		    }
		   }
		  }catch (Exception e) {
		   e.printStackTrace();
		  }finally{
		   if(con != null){
		    try {
		     con.close();
		    } catch (SQLException e) {
		     e.printStackTrace();
		    }
		   }
		  }
		  return flag;
		 }

}