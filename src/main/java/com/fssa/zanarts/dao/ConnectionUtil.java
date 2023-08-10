package com.fssa.zanarts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fssa.zanarts.customexception.ProductExpection;
 
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Utility class for establishing a database connection.
 */
public class ConnectionUtil {

	/**
	 * Establishes a database connection.
	 *
	 * @return A Connection object representing the database connection.
	 * @throws ProductExpection If unable to connect to the database.
	 */
	public static Connection getConnection() throws ProductExpection {
 
		String url;
		String userName;
		String passWord;
		if (System.getenv("CI") != null) {
			url = System.getenv("DATABASE_HOST");
			userName = System.getenv("DATABASE_USERNAME");
			passWord = System.getenv("DATABASE_PASSWORD");
		} else { 
			Dotenv env = Dotenv.load();
			url = env.get("DATABASE_HOST");
			userName = env.get("DATABASE_USERNAME");
			passWord = env.get("DATABASE_PASSWORD");
		}
		 try {
	            return DriverManager.getConnection(url, userName, passWord);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new ProductExpection("Unable to connect to the database");
	        }
	}

	private ConnectionUtil() {
	}

}
