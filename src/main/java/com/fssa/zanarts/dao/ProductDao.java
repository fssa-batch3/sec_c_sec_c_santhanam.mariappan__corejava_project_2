package com.fssa.zanarts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.model.Product;

public class ProductDao {
 
	/**
	 * @author Santhanam Mariappan Method to add a product table to the database.
	 *
	 * @return true if the product was added successfully.
	 * @throws SQLException    if there's an error with the database operation.
	 * @throws CustomExpection
	 */

	public static boolean addProduct(Product product) throws SQLException, ProductExpection {

		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "INSERT INTO products (productname, artistname, price, productDescription, imageurl, category, width, height) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, product.getProductname());
				pst.setString(2, product.getArtistname());
				pst.setDouble(3, product.getPrice());
				pst.setString(4, product.getProductDescription());
				pst.setString(5, product.getImageurl());
				pst.setString(6, product.getCategory().getTypes());
				pst.setInt(7, product.getSize().getWidth());
				pst.setInt(8, product.getSize().getHeight());

				pst.executeUpdate();
				System.out.println("Product Added Successfully");

			}

		} catch (SQLException ex) {
			throw new SQLException(CustomErrors.ADDING_FAILED);
		}

		return true;

	}

	// Method to update a product in the database using artist name as a filter.
	// Returns true if the product was updated successfully, false otherwise.
	// Throws SQLException if there's an error with the database operation.

	public static boolean updateProduct(Product product) throws SQLException, ProductExpection {

		if (product.getId() <= 0) {
			throw new ProductExpection(CustomErrors.INVALID_PRODUCTID);
		}
		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "UPDATE products SET productname = ?, price = ?, productDescription = ?, imageurl = ?, category = ?, width = ?, height = ? WHERE id = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, product.getProductname());
				pst.setDouble(2, product.getPrice());
				pst.setString(3, product.getProductDescription());
				pst.setString(4, product.getImageurl());
				pst.setString(5, product.getCategory().getTypes());
				pst.setInt(6, product.getSize().getWidth());
				pst.setInt(7, product.getSize().getHeight());
				pst.setInt(8, product.getId());

				pst.executeUpdate();
				System.out.println("Product Updated Successfully");

			}

		} catch (SQLException ex) {
			throw new SQLException(CustomErrors.UPDATE_ERROR);
		}

		return true;

	}

	// Method to delete a product from the database using the product ID.
	// Returns true if the product was deleted successfully, false otherwise.
	// Throws SQLException if there's an error with the database operation.

	public static boolean deleteProduct(int productId) throws SQLException, ProductExpection {

		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "DELETE FROM products WHERE id = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setInt(1, productId);
				pst.executeUpdate();
				System.out.println("Product Deleted Successfully");

			}

		} catch (SQLException ex) {
			throw new SQLException(CustomErrors.DELETE_ERROR);
		}

		return true;

	}

	// Method to retrieve and print all product details from the database.
	// Throws SQLException if there's an error with the database operation.
	public static boolean getAllProductDetails() throws SQLException, ProductExpection {

		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "SELECT * FROM products";
			try (Statement st = con.createStatement()) {

				try (ResultSet rs = st.executeQuery(query)) {

					while (rs.next()) {

						System.out.println("ID: " + rs.getInt("id") + ", Product Name: " + rs.getString("productname")
								+ ", Artist Name: " + rs.getString("artistname") + ", Price: " + rs.getDouble("price")
								+ ", Upload Time: " + rs.getString("updateTimestamp") + ", Product Description: "
								+ rs.getString("productDescription") + ", imageurl: " + rs.getString("imageurl")
								+ ", width: " + rs.getInt("width") + ", Height: " + rs.getInt("height") + ", Category: "
								+ rs.getString("height"));

					}

					System.out.println("Sucessfully product details showed");

				}

			}

		} catch (SQLException ex) {
			throw new SQLException(CustomErrors.DETAILS_ERROR);
		}

		return true;

	}

}
