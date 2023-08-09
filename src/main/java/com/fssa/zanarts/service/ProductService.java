package com.fssa.zanarts.service;

import java.sql.SQLException;

import com.fssa.zanarts.customexception.CustomExpection;
import com.fssa.zanarts.dao.ProductDao;

import com.fssa.zanarts.model.Product;

import com.fssa.zanarts.validator.ProductValidator;

/**
 * This class provides methods to manage product-related operations.
 */

public class ProductService {

	/**
	 * Adds a new product to the database.
	 *
	 * @param product The product to be added.
	 * @return {@code true} if the product was successfully added, {@code false}
	 *         otherwise.
	 * @throws SQLException    If a database error occurs.
	 * @throws CustomExpection If there is a custom validation error.
	 */

	public static boolean addproduct(Product product) throws SQLException, CustomExpection {
		if (ProductValidator.validate(product)) {
			ProductDao.addProduct(product);
		}
		return true;
	}

	/**
	 * Updates an existing product in the database.
	 *
	 * @param product The product to be updated.
	 * @return {@code true} if the product was successfully updated, {@code false}
	 *         otherwise.
	 * @throws SQLException    If a database error occurs.
	 * @throws CustomExpection If there is a custom validation error.
	 */
	public static boolean updateProduct(Product product) throws SQLException, CustomExpection {
		if (ProductValidator.validate(product)) {
			ProductDao.updateProduct(product);
		}
		return true;
	}

	/**
	 * Retrieves details of all products from the database.
	 *
	 * @return {@code true} if product details were successfully retrieved,
	 *         {@code false} otherwise.
	 * @throws SQLException    If a database error occurs.
	 * @throws CustomExpection If there is a custom validation error.
	 */
	public static boolean getAllProductDetails() throws SQLException {
		ProductDao.getAllProductDetails();
		return true;
	}

	/**
	 * Deletes a product from the database by its ID.
	 *
	 * @param productId The ID of the product to be deleted.
	 * @return {@code true} if the product was successfully deleted, {@code false}
	 *         otherwise.
	 * @throws SQLException           If a database error occurs.
	 * @throws IllegalAccessException If the operation is not allowed due to access
	 *                                restrictions.
	 * @throws CustomExpection        If there is a custom validation error.
	 */
	public static boolean deleteProduct(int productId) throws SQLException, CustomExpection {
		if (ProductValidator.validateProductId(productId)) {
			ProductDao.deleteProduct(productId);
		}
		return true;
	}

}
