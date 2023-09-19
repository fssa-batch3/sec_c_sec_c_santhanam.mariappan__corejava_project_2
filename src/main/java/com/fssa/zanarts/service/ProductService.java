package com.fssa.zanarts.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.zanarts.customexception.DAOException;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.dao.ProductDao;
import com.fssa.zanarts.dao.UserDao;
import com.fssa.zanarts.logger.Logger;
import com.fssa.zanarts.model.Product;
import com.fssa.zanarts.validator.ProductValidator;

/**
 * This class provides methods to manage product-related operations.
 */

public class ProductService {
	static Logger log = new Logger();

	/**
	 * Adds a new product to the database.
	 *
	 * @param product The product to be added.
	 * @return {@code true} if the product was successfully added, {@code false}
	 *         otherwise.
	 * @throws SQLException           If a database error occurs.
	 * @throws DAOException 
	 * @throws ClassNotFoundException
	 * @throws CustomExpection        If there is a custom validation error.
	 */

	public static boolean addProduct(Product product) throws SQLException, ProductExpection, DAOException {
		System.out.println(product.toString());
		if (ProductValidator.validate(product)) {
			ProductDao.addProduct(product);
		}
		log.info("Added to DB successfully!");
		return true;
	}

	/**
	 * Updates an existing product in the database.
	 *
	 * @param product The product to be updated.
	 * @return {@code true} if the product was successfully updated, {@code false}
	 *         otherwise.
	 * @throws SQLException
	 * @throws SQLException.   If a database error occurs.
	 * @throws CustomExpection If there is a custom validation error.
	 */
	public static boolean updateProduct(Product product, int id) throws ProductExpection, SQLException {
		if (ProductValidator.validate(product)) {
			ProductDao.updateProduct(product, id);
		}
		log.info("Sucessfully product update");
		return true;
	}
 
	/**
	 * Retrieves details of all products from the database.
	 *
	 * @return {@code true} if product details were successfully retrieved,
	 *         {@code false} otherwise.
	 * @throws ProductExpection
	 * @throws SQLException           If a database error occurs.
	 * @throws ClassNotFoundException
	 * @throws DAOException
	 * @throws CustomExpection        If there is a custom validation error.
	 */
//	public static boolean getAllProductDetails() throws SQLException, ProductExpection {
//		ProductDao.
//		return true;
//	}
	
	
	// reading product
		public static Product readProduct(int id) throws SQLException, DAOException, ProductExpection {

			if (ProductValidator.validateProductId(id)) {
				return ProductDao.readProduct(id);
			}
			log.info("Sucessfully product shown");
			return null;
		}
		
		
		

	public List<Product> getAllProductDetails() throws ProductExpection, DAOException {
		ProductDao pd = new ProductDao();
		log.info("Successfully All product showed");
		return pd.getAllProductDetails();

	}
	public List<Product> getArtistProductDetails(String email) throws ProductExpection, DAOException {
		ProductDao pd = new ProductDao();
		log.info("Successfully All product showed");
		return pd.getArtistProducts(UserDao.getUserIdByEmail(email));

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
	public static boolean deleteProduct(int productId) throws SQLException, ProductExpection {
		if (ProductValidator.validateProductId(productId)) {
			ProductDao.deleteProduct(productId);
		}

		log.info("Successfully product Deleted");
		return true;
	}

}
