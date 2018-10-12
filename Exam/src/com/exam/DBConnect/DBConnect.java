package com.exam.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection() {
		System.out.println("Creating postgres DataBase Connection");
		Connection con = null;
		try {
			// Provide database Driver according to your database
			Class.forName("org.postgresql.Driver");
			System.out.println("PostgreSQL driver loaded");

			// Provide URL, database and credentials according to your database
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Exam", "postgres",
					"postgres");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		if (con != null) {
			// System.out.println("Connection created successfully....");
		}
		return con;
	}
}
