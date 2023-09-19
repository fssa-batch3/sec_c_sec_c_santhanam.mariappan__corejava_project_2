package com.fssa.zanarts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fssa.zanarts.customexception.ProductExpection;

//import io.github.cdimascio.dotenv.Dotenv; 

/**
 * Utility class for establishing a database connection.
 */

public class ConnectionUtil {

	/**
	 * Establishes a database connection.
	 *
	 * @return A Connection object representing the database connection.
	 * @throws ProductExpection       If unable to connect to the database.
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() {

		String url;
		String userName;
		String passWord;

		url = System.getenv("DATABASE_HOST");
		userName = System.getenv("DATABASE_USERNAME");
		passWord = System.getenv("DATABASE_PASSWORD");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, userName, passWord);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database");
		}
	}

	private ConnectionUtil() {
	}

}
