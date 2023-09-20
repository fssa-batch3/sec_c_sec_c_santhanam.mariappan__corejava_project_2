package com.fssa.zanarts.model;

import java.util.List;

import com.fssa.zanarts.enumclass.OrderStatus;
import com.fssa.zanarts.enumclass.OrderedProduct;

public class Order {

	private int userID;
	private String productname;
	private double price;
	private int orderId;
	private int quantity;
	private OrderStatus status;
	private double totalAmount;
	private String notes;

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Order(int userID, String productname, double price, int orderId, int quantity, OrderStatus status,
			double totalAmount, String notes) {
		super();
		this.userID = userID;
		this.productname = productname;
		this.price = price;
		this.orderId = orderId;
		this.quantity = quantity;

		this.status = status;
		this.totalAmount = totalAmount;
		this.notes = notes;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
}
