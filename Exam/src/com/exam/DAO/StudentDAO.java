package com.exam.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.exam.DBConnect.DBConnect;

public class StudentDAO {
	
	public static boolean insertStudents(String aadhar, String name) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection con = null;
		try{
			con = DBConnect.getConnection();
			String query = "INSERT into student(aadharNumber,studentName) values(?,?)";
			
			//insert data using PreparedStatement
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, aadhar);
			ps.setString(2, name);
			
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