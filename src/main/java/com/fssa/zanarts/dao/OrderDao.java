package com.fssa.zanarts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.DAOException;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.logger.Logger;
import com.fssa.zanarts.model.Order;
//import com.fssa.zanarts.service.CustomExpection; 

public class OrderDao {

	public static void addOrder(Order order) throws DAOException, SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			// SQL query to insert the order information into the 'orders' table
			String insertQuery = "INSERT INTO orders (orderId, user_id, productname, price, quantity, status, totalAmount, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			// Execute insert statementorderId
			try (PreparedStatement pst = connection.prepareStatement(insertQuery)) {

				pst.setInt(1, order.getOrderId());
				pst.setInt(2, order.getUserID());
				pst.setString(3, order.getProductname());
				pst.setDouble(4, order.getPrice());
				pst.setInt(5, order.getQuantity());
				System.out.println(order.getStatus().getValue());
				pst.setString(6, order.getStatus().getValue());
				pst.setDouble(7, order.getTotalAmount());
				pst.setString(8, order.getNotes());

				// Execute the insert statement and get the number of affected rows
				int rowsAffected = pst.executeUpdate();
				Logger.info("row/rows affected: " + rowsAffected);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(CustomErrors.ORDER_CREATION_FAILED);
		}
	}

	
	
//	delete order

	public static boolean deleteOrder(int OrderId) throws SQLException {

		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "DELETE FROM orders WHERE orderId = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setInt(1, OrderId);
				pst.executeUpdate();
			}

		} catch (SQLException ex) {
			throw new SQLException(CustomErrors.DELETE_ERROR);
		}

		return true;

	}

}
