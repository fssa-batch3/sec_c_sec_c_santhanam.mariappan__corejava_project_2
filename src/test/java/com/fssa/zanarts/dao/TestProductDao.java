package com.fssa.zanarts.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.DAOException;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.enumclass.Types;
import com.fssa.zanarts.logger.Logger;
import com.fssa.zanarts.model.Dimension;
import com.fssa.zanarts.model.Product;

/**
 * Unit tests for the ProductDao class.
 */

class TestProductDao {

	// Create a valid Product for testing purposes
  
	public static Product validProduct() {
		Dimension dm = new Dimension(100, 100);
		Product product = new Product();
		product.setname("Santhanam");
		product.setArtistname("Santhanam");
		product.setId(1);
		product.setPrice(300.0);
		product.setCategory(Types.MANDANA);
		product.setSize(dm);
		product.setProductDescription("Santhanam is my frist art");
		product.setUrl("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg");
		product.setUploadTime(null);

		return product;

	} 

	// Create an invalid Product for negative testing

	Product invalidProduct() {
		Dimension dm = new Dimension(100, 100);
		Product product = new Product();
		product.setname("");
		product.setArtistname("Santhanam");
		product.setId(-1);
		product.setPrice(300.0);
		product.setCategory(Types.MANDANA);
		product.setSize(dm);
		product.setProductDescription("Santhanam is my frist art");
		product.setUrl("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg");
		product.setUploadTime(null);

		return product;

	} 

	// Test the 'addProduct' method with a valid Product
	@Test
	void testValidAddProduct() throws SQLException, ProductExpection, ClassNotFoundException {
		Assertions.assertTrue(ProductDao.addProduct(validProduct()));
	}

	// Test the 'updateProduct' method with a valid Product
	@Test
	void testValidUpdateProduct() throws SQLException, ProductExpection {
		Assertions.assertTrue(ProductDao.updateProduct(validProduct(), 3));
	}

	// Test the 'deleteProduct' method with a valid Product ID
	@Test
	void testValidDeleteProduct() throws SQLException, ProductExpection {
		Assertions.assertTrue(ProductDao.deleteProduct(validProduct().getId()));
	}

	// Test the 'getAllProductDetails' method to get all product details
	@Test
	void testValidGetProductDetails() throws SQLException, ProductExpection, DAOException, ClassNotFoundException {
		ProductDao pd = new ProductDao();

		List<Product> productList = pd.getAllProductDetails();
		for (Product ele : productList) {
			Logger.info(ele);
		}

	}

	/**
	 * Test updating a product with an invalid ID.
	 *
	 * @throws DAOException    If a DAO exception occurs.
	 * @throws SQLException    If an SQL exception occurs.
	 * @throws ClassNotFoundException 
	 * @throws CustomExpection If a custom exception occurs.
	 */
	@Test
	void testInvalidAddProduct() throws SQLException, ProductExpection, ClassNotFoundException {

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
	void testInvalidUpdateProductId() throws DAOException, SQLException, ProductExpection {
		// Expecting the method to throw an SQLException with a specific error message
		try {
			Product product = new Product();
			product.setId(-1);
			ProductDao.updateProduct(product,3);
		} catch (ProductExpection ex) {
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
	void testInvalidDeltProductId() throws ProductExpection, DAOException, SQLException {

		try {
			ProductDao.deleteProduct(invalidProduct().getId());
		} catch (SQLException ex) {
			Assertions.assertEquals(CustomErrors.INVALID_PRODUCTID, ex.getMessage());
		}

	}

}