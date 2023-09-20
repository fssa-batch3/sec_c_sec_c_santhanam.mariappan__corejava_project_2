package com.fssa.zanarts.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.OrderException;
import com.fssa.zanarts.enumclass.OrderStatus;
import com.fssa.zanarts.enumclass.OrderedProduct;
import com.fssa.zanarts.model.Order;

public class OrderValidator {

	public static boolean validate(Order product) throws OrderException {

		if (product == null) {
			throw new OrderException(CustomErrors.INVALID_OBJECT_NULL);
		}

		return true;

	}
	
//	order id 
	public static boolean validateOrderId(int orderId) throws OrderException {

		if (orderId<=0) {
			throw new OrderException(CustomErrors.ORDER_ID);
		}

		return true;
	}

//	for name
	public static boolean validateName(String name) throws OrderException {

		if (name == null || "".equals(name.trim())) {
			throw new OrderException(CustomErrors.INVALID_PRODUCTNAME_NULL);
		}

		String nameregex = "^[A-Za-z]{3,100}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(name);
		Boolean isMatch = matcher.matches();

		if (!isMatch)
			throw new OrderException(CustomErrors.INVALID_LENGTH_PRODUCT_NAME);

		return true;
	}

//	quantity

	public static boolean validateQuantity(int quantity) throws OrderException {
		if (quantity <= 0) {
			throw new OrderException(CustomErrors.INVALID_QUANTITY);
		}
		return true;
	}

//	list
	public static boolean validateProductsList(List<OrderedProduct> productsList) throws OrderException {
		if (productsList == null || productsList.isEmpty()) {
			throw new OrderException(CustomErrors.INVALID_LIST);
		}
		return true;
	}

//	total amount

	public static boolean validateTotalAmount(double totalAmount) throws OrderException {
		if (totalAmount <= 0) {
			throw new OrderException(CustomErrors.INVALID_TOTAL_AMOUNT);
		}
		return true;
	}

//	status 
	public static boolean validateStatus(OrderStatus status) throws OrderException {

		if (status == null) {
			throw new OrderException(CustomErrors.INVALID_STATUS);
		}
		return true;
	}
	

//	 for notes
	public static boolean validateNotes(String notes) throws OrderException {
		// Assuming "notes" can contain any characters (no specific validation required)
		// You may customize this validation to your specific requirements

		if (notes == null || notes.trim().isEmpty()) {
			throw new OrderException(CustomErrors.INVALID_NOTES);
		}
		
		return true;
	}
}
