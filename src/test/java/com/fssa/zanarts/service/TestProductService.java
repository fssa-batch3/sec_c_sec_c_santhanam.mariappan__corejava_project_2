package com.fssa.zanarts.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.zanarts.customexception.CustomExpection;
import com.fssa.zanarts.model.Dimension;
import com.fssa.zanarts.model.Product;

/**
 * Unit tests for the ProductService class.
 */
public class TestProductService {

	@Test
	public static Product validProduct() {
		Dimension dm = new Dimension(100, 100);
		Product product = new Product();
		product.setProductname("Santhanam");
		product.setArtistname("Santhanam");
		product.setId(70);
		product.setPrice(300.0);
		product.setCategory("MANDANA");
		product.setSize(dm);
		product.setProductDescription("Santhanam is my frist art");
		product.setUrl("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg");
		product.setUploadTime(null);

		return product;
	}
//
//	public static Product inValidProduct() {
//		Dimension dm = new Dimension(100, 100);
//		Product product = new Product();
//		product.setProductname("");
//		product.setArtistname("Santhanam");
//		product.setId(0);
//		product.setPrice(300.0);
//		product.setCategory(" ");
//		product.setSize(dm);
//		product.setProductDescription("Santhanam is my frist art");
//		product.setUrl("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg");
//		product.setUploadTime(null);
//
//		return product;
//	}

	/**
	 * Test adding a valid product.
	 *
	 * @throws CustomExpection If a custom exception occurs.
	 * @throws SQLException    If an SQL exception occurs.
	 */
	@Test
	public void testValidAddProduct() throws CustomExpection, SQLException {

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
	public void testValidUpdateProduct() throws CustomExpection, SQLException {
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
	public void testValidDeleteProduct() throws CustomExpection, SQLException, IllegalAccessException {
		Assertions.assertTrue(ProductService.deleteProduct(70));
	}

//	view
	@Test
	public void testValidGetAllProductDetails() throws CustomExpection, SQLException {
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