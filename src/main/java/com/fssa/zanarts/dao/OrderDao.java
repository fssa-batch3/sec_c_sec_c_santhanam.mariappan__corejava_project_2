package com.fssa.zanarts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.DAOException;
import com.fssa.zanarts.logger.Logger;
import com.fssa.zanarts.model.Order;
//import com.fssa.zanarts.service.CustomExpection; 

public class OrderDao {

	public static void addOrder(Order order) throws DAOException, SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			// SQL query to insert the order information into the 'orders' table
			String insertQuery = "INSERT INTO orders ( user_id, productname, price, quantity, status, totalAmount, notes, product_id) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

			// Execute insert statementorderId
			try (PreparedStatement pst = connection.prepareStatement(insertQuery)) {

				pst.setInt(1, order.getUserID());
				pst.setString(2, order.getProductname());
				pst.setDouble(3, order.getPrice());
				pst.setInt(4, order.getQuantity());
				pst.setString(5, order.getStatus().getValue());
				pst.setDouble(6, order.getTotalAmount());
				pst.setString(7, order.getNotes());
				pst.setInt(8, order.getProductId());

				// Execute the insert statement and get the number of affected rows
				int rowsAffected = pst.executeUpdate();
				Logger.info("row/rows affected: " + rowsAffected);
			}
		} catch (SQLException e) {
			Logger.info(e.getMessage());
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

//	order list
	public ArrayList<Order> getOrderById(int userId) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM `orders` WHERE user_id = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setInt(1, userId);

				try (ResultSet resultSet = pst.executeQuery()) {
					ArrayList<Order> orders = new ArrayList<Order>();
					while (resultSet.next()) {
						Order order = new Order();

						order.setOrderId(resultSet.getInt("orderId"));
						order.setProductname(resultSet.getString("productname"));
						order.setPrice(resultSet.getInt("price"));
						order.setTotalAmount(resultSet.getInt("totalAmount"));
						order.setUserID(resultSet.getInt("user_id"));
						order.setQuantity(resultSet.getInt("quantity"));
						order.setProductId(resultSet.getInt("product_id"));
						orders.add(order);

					}
					return orders;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(CustomErrors.ORDER_RETRIEVAL_FAILED);
		}

	}
}
