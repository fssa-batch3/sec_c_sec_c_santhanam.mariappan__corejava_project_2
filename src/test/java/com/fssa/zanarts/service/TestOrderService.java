package com.fssa.zanarts.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.zanarts.customexception.DAOException;
import com.fssa.zanarts.customexception.OrderException;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.enumclass.OrderStatus;
import com.fssa.zanarts.logger.Logger;
import com.fssa.zanarts.model.Order;
import com.fssa.zanarts.model.Product;

public class TestOrderService {

	static Order validOrder() {

		Order order = new Order();
		order.setProductname("MyDrawings");
		order.setPrice(200);
		order.setOrderId(1);
		order.setQuantity(1);
		order.setStatus(OrderStatus.ORDERED);
		order.setTotalAmount(2000);
		order.setUserID(1);
		order.setNotes("hello all");
 
		return order;

	}

//	valid add order
	@Test
	void testValidAddOrder() throws OrderException, SQLException, DAOException {
		TestOrderService testOrder = new TestOrderService();
		Assertions.assertTrue(OrderService.addOrder(TestOrderService.validOrder()));

	}

	
//	delete add order
	@Test
	void testValidDeleteOrder() throws OrderException, SQLException {
		Assertions.assertTrue((OrderService.deleteOrder(1)));
	}
	
	@Test
	void testValidGetAllOrderDetails() throws DAOException, ProductExpection, SQLException {
		OrderService testOrder = new OrderService();
		List<Order> OrderList = testOrder.getOrderById(8);
		
 		for (Order ele : OrderList) {
			Logger.info(ele.getProductname());
		}
	}
	
 
}
