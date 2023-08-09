package com.fssa.zanarts.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.logger.Logger;
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
        Connection con = null;
        String url;
        String userName;
        String passWord;
        try {
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
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, passWord);
            Logger.info("Connected to database");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ProductExpection("JDBC Driver not found");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductExpection("Unable to connect to the database");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return con;
    }

    public static void main(String[] args) throws ProductExpection {
        try {
            Connection connection = getConnection();
            // Use the database connection
        } catch (ProductExpection e) {
            e.printStackTrace();
        }
    }
}
