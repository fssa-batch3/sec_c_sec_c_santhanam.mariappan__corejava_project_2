package com.fssa.zanarts.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.zanarts.customexception.DAOException;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.enumclass.Types;
import com.fssa.zanarts.logger.Logger;
import com.fssa.zanarts.model.Dimension;
import com.fssa.zanarts.model.Product;

/**
 * Unit tests for the ProductService class.
 */
class TestProductService {

	static Product validProduct() {

		Dimension dm = new Dimension(100, 100);
		Product product = new Product();
		product.setname("Bharathi");
		product.setArtistname("Denny");
		product.setId(1);
		product.setPrice(400.0);
		product.setCategory(Types.WATERCOLOUR);
		product.setSize(dm);
		product.setProductDescription("My Second art");
		product.setUrl("https://iili.io/Hy1IArb.jpg");
		product.setUploadTime(null);
		return product;
	}

	/**
	 * Test adding a valid product.
	 *
	 * @throws CustomExpection        If a custom exception occurs.
	 * @throws SQLException           If an SQL exception occurs.
	 * @throws DAOException
	 * @throws ClassNotFoundException
	 */

	@Test
	void testValidAddProduct() throws ProductExpection, SQLException, DAOException {

		TestProductService testProduct = new TestProductService();
		Assertions.assertTrue(ProductService.addProduct(testProduct.validProduct()));

	}

	/**
	 * Test updating a valid product.
	 *
	 * @throws CustomExpection If a custom exception occurs.
	 * @throws SQLException    If an SQL exception occurs.
	 */

	@Test
	void testValidUpdateProduct() throws ProductExpection, SQLException {
		TestProductService testProduct = new TestProductService();
		Assertions.assertTrue(ProductService.updateProduct(testProduct.validProduct(), 1));
	}

	/**
	 * Test deleting a valid product.
	 *
	 * @throws CustomExpection        If a custom exception occurs.
	 * @throws SQLException           If an SQL exception occurs.
	 * @throws IllegalAccessException If an IllegalAccessException occurs.
	 */

	@Test
	void testValidDeleteProduct() throws ProductExpection, SQLException {
		Assertions.assertTrue(ProductService.deleteProduct(1));
	}

//	view
	@Test
	void testValidGetAllProductDetails() throws DAOException, ProductExpection {
		ProductService ps = new ProductService();
		List<Product> productList = ps.getAllProductDetails();
		for (Product ele : productList) {
			Logger.info(ele);
		}
	}

	@Test
	void testReadProduct() {
		ProductService productservices = new ProductService();
		assertDoesNotThrow(() -> productservices.readProduct(1));
	}

	@Test
	void testgetArtistProductDetailsById() throws ProductExpection, SQLException, DAOException {
		ProductService ps = new ProductService();
		List<Product> productList = ps.getArtistProductDetailsById(11);
		for (Product ele : productList) {
			Logger.info(ele);
		}
	}

}