package com.fssa.zanarts.dao;

import java.sql.SQLException;

import com.fssa.zanarts.customexception.DAOException;
import com.fssa.zanarts.customexception.OrderException;
import com.fssa.zanarts.logger.Logger;
import com.fssa.zanarts.model.Order;
import com.fssa.zanarts.validator.OrderValidator;

public class TestOrderDao {
	static Logger log = new Logger();

	public static boolean addOrder(Order order) throws SQLException, DAOException, OrderException {

		if (OrderValidator.validate(order)) {
			TestOrderDao.addOrder(order);
		}
		
		log.info("Added to DB successfully!");
		return true;
	}
	
	

}
