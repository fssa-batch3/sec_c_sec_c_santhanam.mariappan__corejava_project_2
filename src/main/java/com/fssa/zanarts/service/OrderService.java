package com.fssa.zanarts.service;

import java.sql.SQLException;

import com.fssa.zanarts.customexception.DAOException;
import com.fssa.zanarts.customexception.OrderException;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.dao.OrderDao;
import com.fssa.zanarts.dao.ProductDao;
import com.fssa.zanarts.logger.Logger;
import com.fssa.zanarts.model.Order;
import com.fssa.zanarts.validator.OrderValidator;
import com.fssa.zanarts.validator.ProductValidator;

public class OrderService {

	static Logger log = new Logger();

	public static boolean addOrder(Order order) throws SQLException, OrderException, DAOException {

		if (OrderValidator.validate(order)) {
			OrderDao.addOrder(order);
			log.info("Added to DB successfully!");
		}

		return true;
	}
	
	
	
//	delete 
	
	
	public static boolean deleteOrder(int OrderId) throws SQLException, OrderException {
		if (OrderValidator.validateOrderId(OrderId)) {
			OrderDao.deleteOrder(OrderId);
		}

		log.info("Successfully product Deleted");
		return true;
	}

}
