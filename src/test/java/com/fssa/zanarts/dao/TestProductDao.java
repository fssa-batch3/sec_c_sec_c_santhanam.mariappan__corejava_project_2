package com.fssa.zanarts.dao;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.CustomExpection;
import com.fssa.zanarts.customexception.DAOException;

import com.fssa.zanarts.model.Dimension;
import com.fssa.zanarts.model.Product;

/**
 * Unit tests for the ProductDao class.
 */

public class TestProductDao {

	// Create a valid Product for testing purposes
	@Test
	public static Product validProduct() {
		Dimension dm = new Dimension(100, 100);
		Product product = new Product();
		product.setProductname("Santhanam");
		product.setArtistname("Santhanam");
		product.setId(1);
		product.setPrice(300.0);
		product.setCategory("MANDANA");
		product.setSize(dm);
		product.setProductDescription("Santhanam is my frist art");
		product.setUrl("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg");
		product.setUploadTime(null);

		return product;

	}

	// Create an invalid Product for negative testing
	@Test
	public static Product invalidProduct() {
		Dimension dm = new Dimension(100, 100);
		Product product = new Product();
		product.setProductname("");
		product.setArtistname("Santhanam");
		product.setId(-1);
		product.setPrice(300.0);
		product.setCategory("MANDANA");
		product.setSize(dm);
		product.setProductDescription("Santhanam is my frist art");
		product.setUrl("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg");
		product.setUploadTime(null);

		return product;

	}

	// Test the 'addProduct' method with a valid Product
	@Test
	public void testValidAddProduct() throws SQLException {
		Assertions.assertTrue(ProductDao.addProduct(validProduct()));
	}

	// Test the 'updateProduct' method with a valid Product
	@Test
	public void testValidUpdateProduct() throws SQLException, CustomExpection {
		Assertions.assertTrue(ProductDao.updateProduct(validProduct()));
	}

	// Test the 'deleteProduct' method with a valid Product ID
	@Test
	public void testValidDeleteProduct() throws SQLException {
		Assertions.assertTrue(ProductDao.deleteProduct(validProduct().getId()));
	}

	// Test the 'getAllProductDetails' method to get all product details
	@Test
	public void testValidGetProductDetails() throws SQLException {
		ProductDao pd = new ProductDao();
		Assertions.assertTrue(ProductDao.getAllProductDetails());
	}

	/**
	 * Test updating a product with an invalid ID.
	 *
	 * @throws DAOException    If a DAO exception occurs.
	 * @throws SQLException    If an SQL exception occurs.
	 * @throws CustomExpection If a custom exception occurs.
	 */
	@Test
	public void testInvalidAddProduct() throws SQLException {

		try {
			ProductDao.addProduct(invalidProduct());
		} catch (SQLException ex) {
			Assertions.assertEquals(CustomErrors.ADDING_FAILED, ex.getMessage());
		}

	}

	@Test

	/**
	 * Test updating a product with an invalid ID.
	 *
	 * @throws DAOException    If a DAO exception occurs.
	 * @throws SQLException    If an SQL exception occurs.
	 * @throws CustomExpection If a custom exception occurs.
	 */
	public void testInvalidUpdateProductId() throws DAOException, SQLException, CustomExpection {
		// Expecting the method to throw an SQLException with a specific error message
		try {
			Product product = new Product();
			product.setId(-1);
			ProductDao.updateProduct(product);
		} catch (CustomExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_PRODUCTID, ex.getMessage());
		}

	}

	/**
	 * Test deleting a product with an invalid ID.
	 *
	 * @throws CustomExpection If a custom exception occurs.
	 * @throws DAOException    If a DAO exception occurs.
	 * @throws SQLException    If an SQL exception occurs.
	 */

	@Test
	public void testInvalidDeltProductId() throws CustomExpection, DAOException, SQLException {

		try {
			ProductDao.deleteProduct(invalidProduct().getId());
		} catch (SQLException ex) {
			Assertions.assertEquals(CustomErrors.INVALID_PRODUCTID, ex.getMessage());
		}

	}

}