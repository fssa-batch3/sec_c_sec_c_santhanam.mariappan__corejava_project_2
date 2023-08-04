package com.fssa.zanarts.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	public static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/Zanarts";
		String userName = "root";
		String passWord = "123456";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database");
		}
		System.out.println("connection successful");
		return con;
	}

}

