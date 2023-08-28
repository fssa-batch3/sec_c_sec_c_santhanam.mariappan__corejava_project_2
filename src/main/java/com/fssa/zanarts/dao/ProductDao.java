package com.fssa.zanarts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.DAOException;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.enumclass.Types;
import com.fssa.zanarts.model.Dimension;
import com.fssa.zanarts.model.Product;

public class ProductDao {

	/**
	 * @author Santhanam Mariappan Method to add a product table to the database.
	 *
	 * @return true if the product was added successfully.
	 * @throws SQLException           if there's an error with the database
	 *                                operation.
	 * @throws ClassNotFoundException
	 * @throws CustomExpection
	 */

	public static boolean addProduct(Product product) throws SQLException, ProductExpection, ClassNotFoundException {

		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "INSERT INTO products (name, artistname, price, productDescription, imageurl, category, width, height) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, product.getname());
				pst.setString(2, product.getArtistname());
				pst.setDouble(3, product.getPrice());
				pst.setString(4, product.getProductDescription());
				pst.setString(5, product.getImageurl());
				pst.setString(6, product.getCategory().getTypes());
				pst.setInt(7, product.getSize().getWidth());
				pst.setInt(8, product.getSize().getHeight());

				pst.executeUpdate();

			}

		} catch (SQLException ex) {
			throw new SQLException(CustomErrors.ADDING_FAILED + ex.getMessage());
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

			final String query = "UPDATE products SET name = ?, price = ?, productDescription = ?, imageurl = ?, category = ?, width = ?, height = ? WHERE id = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, product.getname());
				pst.setDouble(2, product.getPrice());
				pst.setString(3, product.getProductDescription());
				pst.setString(4, product.getImageurl());
				pst.setString(5, product.getCategory().getTypes());
				pst.setInt(6, product.getSize().getWidth());
				pst.setInt(7, product.getSize().getHeight());
				pst.setInt(8, product.getId());

				pst.executeUpdate();

			}

		} catch (SQLException ex) {
			throw new SQLException(CustomErrors.UPDATE_ERROR);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

			}

		} catch (SQLException ex) {
			throw new SQLException(CustomErrors.DELETE_ERROR);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;

	}

	// Method to retrieve and print all product details from the database.
	// Throws SQLException if there's an error with the database operation.
	public List<Product> getAllProductDetails() throws ProductExpection, ClassNotFoundException, DAOException {

		List<Product> productList = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "SELECT * FROM products";
			try (Statement st = con.createStatement()) {

				try (ResultSet rs = st.executeQuery(query)) {

					while (rs.next()) {

						Product product = new Product();
						product.setArtistname(rs.getString("artistname"));
						product.setId(rs.getInt("id"));
						product.setImageurl(rs.getString("imageurl"));
						product.setPrice(rs.getDouble("price"));

						product.setCategory(Types.valueToEnumMapping(rs.getString("category").toLowerCase()));
						product.setname(rs.getString("name"));
						Dimension dim = new Dimension();
						dim.setHeight(rs.getInt("height"));
						dim.setWidth(rs.getInt("width"));
						product.setSize(dim);
						product.setUploadTime(rs.getTimestamp("updateTimestamp").toLocalDateTime());
						product.setId(rs.getInt("id"));
						product.setProductDescription(rs.getString("productDescription"));

						productList.add(product);
						System.out.println(product.getCategory());
//
//						System.out.println("ID: " + rs.getInt("id") + ", Product Name: " + rs.getString("name")
//								+ ", Artist Name: " + rs.getString("artistname") + ", Price: " + rs.getDouble("price")
//								+ ", Upload Time: " + rs.getString("updateTimestamp") + ", Product Description: "
//								+ rs.getString("productDescription") + ", imageurl: " + rs.getString("imageurl")
//								+ ", width: " + rs.getInt("width") + ", Height: " + rs.getInt("height") + ", Category: "
//								+ rs.getString("height"));

					}

				}

			}

		} catch (SQLException ex) {
			throw new DAOException(CustomErrors.DETAILS_ERROR);
		}

		return productList;

	}

}
