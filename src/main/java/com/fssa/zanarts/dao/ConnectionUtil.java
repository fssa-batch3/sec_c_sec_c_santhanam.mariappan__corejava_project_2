package com.fssa.zanarts.dao;


import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionUtil {

	public static Connection getConnection() {
		Connection con = null;

		String url, userName, passWord;

		url = System.getenv("DATABASE_HOST1");
		userName = System.getenv("DATABASE_USERNAME1");
		passWord = System.getenv("DATABASE_PASSWORD1");

//		url = System.getenv("CLOUD_DATABASE_HOST");
//		userName = System.getenv("CLOUD_DATABASE_USERNAME");
//		passWord = System.getenv("CLOUD_DATABASE_PASSWORD");
		 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Connection");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database");
		}
		return con;
	}
	
	public static void main(String[] args) {
		System.out.println(ConnectionUtil.getConnection());
	}

}
