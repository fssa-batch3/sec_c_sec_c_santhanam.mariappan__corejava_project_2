package com.fssa.zanarts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.DAOException;
import com.fssa.zanarts.customexception.UserException;
import com.fssa.zanarts.enumclass.Role;
import com.fssa.zanarts.logger.Logger;
import com.fssa.zanarts.model.User;

public class UserDao {

	public static boolean addUser(User user) throws SQLException, UserException {

		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "INSERT INTO users (userName, email, phoneNumber, password, role ) VALUES ( ?, ?, ?, ?, ?)";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, user.getUserName());
				pst.setString(2, user.getEmail());
				pst.setString(3, user.getPhoneNumber());
				pst.setString(4, user.getPassword());
				pst.setString(5, user.getRole().getValue());

				pst.executeUpdate();
			}

		} catch (SQLException ex) {
			throw new SQLException(CustomErrors.ADDING_METHOD_FAIL + ex.getMessage());
		}
		return true;

	}

//	update user
	public static boolean updateUser(User user, int id) throws SQLException, UserException {

		if (user.getId() <= 0) {
			throw new UserException(CustomErrors.INVALID_USER_ID);
		}
		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "UPDATE users SET username = ?, email = ?, phoneNumber = ?, password = ?, role = ?  WHERE id = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, user.getUserName());
				pst.setString(2, user.getEmail());
				pst.setString(3, user.getPhoneNumber());
				pst.setString(4, user.getPassword());
				pst.setString(5, user.getRole().getValue());
				pst.setInt(6, id);

				pst.executeUpdate();

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new SQLException(CustomErrors.UPDATE_USER_ERROR);

		}

		return true;

	}

//	User login

	public static User login(String email, String password) throws DAOException {
		try (Connection con = ConnectionUtil.getConnection()) {
			// SQL query to delete the user from the 'user' table.
			String query = "SELECT * FROM users WHERE email = ? AND password = ?";
			User user;
			System.out.println("email :" + email + " password : " + password);
			// Prepares the SQL query with the user_id.
			try (PreparedStatement psmt = con.prepareStatement(query)) {
				// Sets the user_id in the PreparedStatement.
				psmt.setString(1, email);
				psmt.setString(2, password);
				// Executes the delete query.
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						user = new User();
						user.setEmail(rs.getString("userName"));
						user.setPhoneNumber(rs.getString("phoneNumber"));
						user.setPassword(rs.getString("password"));

						user.setRole(Role.valueOf(rs.getString("role").toUpperCase()));

						// user.setRole(rs.getString("Role") != null ? Role.valueOf("role"):null);

						return user;
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return null;
	}

//	get user by id

	public static boolean updateUser(User user) throws DAOException {
		try (Connection con = ConnectionUtil.getConnection()) {
			// SQL query to update an existing user in the 'users' table.
			String query = "UPDATE users SET first_name=?, last_name=?, email=?,  mobile_num=?, address=?, gender=? WHERE user_id=?";
			// Prepares the SQL query with the provided user details.
			try (PreparedStatement pst = con.prepareStatement(query)) {
				// Sets the user details in the PreparedStatement.
				pst.setString(1, user.getUserName());
				pst.setString(2, user.getEmail());
				pst.setString(3, user.getPhoneNumber());
				pst.setString(4, user.getPassword());
				pst.setString(5, user.getRole().getValue());
				// Assuming you have a 'userId' field in the User
				// object.
				int rowAffected = pst.executeUpdate();
				// Prints the number of rows affected by the update query.
				Logger.info(rowAffected + " row/rows affected");
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return true;
	}

//	Get User id by Email
	public static int getUserIdByEmail(String email) throws DAOException {
		int userId = -1; // Default value if the email is not found or an error occurs.

		// User user = null;
		try (Connection con = ConnectionUtil.getConnection()) {
			// SQL query to retrieve the user ID by email.
			String query = "SELECT id FROM users WHERE email=?";
			try (PreparedStatement psmt = con.prepareStatement(query)) {
				// Set the email parameter in the PreparedStatement.
				psmt.setString(1, email);
				System.out.println(psmt);
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						userId = rs.getInt("id");

						// email, id, username, role
						// user = new User();
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return userId;
//		return user;
	}

	// Get User by Email
	public static User getUserByEmail(String email) throws DAOException {
		User user = null; // Default value if the email is not found or an error occurs.

		try (Connection con = ConnectionUtil.getConnection()) {

			String query = "SELECT id, userName, email, phoneNumber,  role FROM users WHERE email=?";
			try (PreparedStatement psmt = con.prepareStatement(query)) {

				psmt.setString(1, email);
				System.out.println(psmt);
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {

						user = new User();
						user.setId(rs.getInt("id"));
						user.setEmail(rs.getString("email"));
						user.setPhoneNumber(rs.getString("phoneNumber"));
						user.setUserName(rs.getString("userName"));
						user.setRole(Role.valueOf(rs.getString("role").toUpperCase()));

					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return user;
	}

}