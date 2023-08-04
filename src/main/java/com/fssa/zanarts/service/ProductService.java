package com.fssa.zanarts.service;

import java.sql.SQLException;
import java.time.LocalDateTime;

import com.fssa.zanarts.customexception.CustomExpection;
import com.fssa.zanarts.dao.ProductDao;
import com.fssa.zanarts.model.Dimension;
import com.fssa.zanarts.model.Product;
import com.fssa.zanarts.validator.ProductValidator;

public class ProductService {

//	add
	public static boolean addproduct(Product product) throws SQLException, CustomExpection {
		if (ProductValidator.validate(product)) {
			ProductDao.addProduct(product);
		}
		return true;
	}

//	update
	public static boolean updateProduct(Product product) throws SQLException, CustomExpection {
		if (ProductValidator.validate(product)) {
			ProductDao.updateProduct(product);
		}
		return true;
	}

//	read
	public static boolean getAllProductDetails() throws SQLException, CustomExpection {
		ProductDao.getAllProductDetails();
		return true;
	}

//	delete
	public static boolean deleteProduct(int productId) throws SQLException, IllegalAccessException, CustomExpection {
		if (ProductValidator.validateProductId(productId)) {
			ProductDao.deleteProduct(productId);
		}
		return true;
	}

	public static void main(String[] args) throws SQLException, CustomExpection, IllegalAccessException {
		
		Dimension dm = new Dimension();
		dm.setHeight(320);
		dm.setWidth(1100);
		Product p = new Product(13, "Mathankumar", "Santhanam", 300.0, LocalDateTime.now(), "This Art Designed by I", "https://www.timeoutdubai.com/cloud/timeoutdubai/2021/09/11/udHvbKwV-IMG-Dubai-UAE-1-1200x800.jpg",dm, "MANDANA");
		
		System.out.println(deleteProduct(11));
		
	}
	
}
