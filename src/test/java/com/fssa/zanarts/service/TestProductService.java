package com.fssa.zanarts.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.zanarts.customexception.CustomExpection;
import com.fssa.zanarts.model.Dimension;
import com.fssa.zanarts.model.Product;
import com.fssa.zanarts.model.Types;

/**
 * Unit tests for the ProductService class.
 */
class TestProductService { 

	
	 static Product validProduct() {
		Dimension dm = new Dimension(100, 100);
		Product product = new Product();
		product.setProductname("Bharathi");
		product.setArtistname("Chandru");
		product.setId(13);
		product.setPrice(300.0);
		product.setCategory(Types.MANDANA);
		product.setSize(dm);
		product.setProductDescription("Santhanam is my frist art");
		product.setUrl("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg");
		product.setUploadTime(null);

		return product;
	}

	/**
	 * Test adding a valid product.
	 *
	 * @throws CustomExpection If a custom exception occurs.
	 * @throws SQLException    If an SQL exception occurs.
	 */
	@Test
	void testValidAddProduct() throws CustomExpection, SQLException {

		TestProductService testProduct = new TestProductService();
		Assertions.assertTrue(ProductService.addproduct(testProduct.validProduct()));

	}

	/**
	 * Test updating a valid product.
	 *
	 * @throws CustomExpection If a custom exception occurs.
	 * @throws SQLException    If an SQL exception occurs.
	 */

	@Test
	void testValidUpdateProduct() throws CustomExpection, SQLException {
		TestProductService testProduct = new TestProductService();
		Assertions.assertTrue(ProductService.updateProduct(testProduct.validProduct()));
	}

	/**
	 * Test deleting a valid product.
	 *
	 * @throws CustomExpection        If a custom exception occurs.
	 * @throws SQLException           If an SQL exception occurs.
	 * @throws IllegalAccessException If an IllegalAccessException occurs.
	 */
	@Test
	void testValidDeleteProduct() throws CustomExpection, SQLException, IllegalAccessException {
		Assertions.assertTrue(ProductService.deleteProduct(70));
	}

//	view
	@Test
	void testValidGetAllProductDetails() throws CustomExpection, SQLException {
		ProductService productSer = new ProductService();
		Assertions.assertTrue(productSer.getAllProductDetails());
	}

//invalid 
//
//	@Test
//	public void testINvalidAddProduct() throws customExpection, SQLException {
//
//		try {
//			ProductService.addproduct(inValidProduct());
//		} catch (customExpection ex) {
////			ToDo  Message 
//			Assertions.assertEquals("", ex.getMessage());
//		}
//	}

}