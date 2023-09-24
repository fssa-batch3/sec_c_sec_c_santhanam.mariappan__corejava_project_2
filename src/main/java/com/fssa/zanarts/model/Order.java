package com.fssa.zanarts.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fssa.zanarts.enumclass.OrderStatus;

public class Order {

	private int userID;
	private String productname;
	private int productId;
	private double price;
	private int orderId;
	private int quantity;
	private OrderStatus status;
	private double totalAmount;
	private String notes;
	private LocalDateTime uploadTime;

	public LocalDateTime getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(LocalDateTime uploadTime) {
		this.uploadTime = uploadTime;
	}

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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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


	@Override
	public String toString() {
		return "Order [userID=" + userID + ", productname=" + productname + ", productId=" + productId + ", price="
				+ price + ", orderId=" + orderId + ", quantity=" + quantity + ", status=" + status + ", totalAmount="
				+ totalAmount + ", notes=" + notes + ", uploadTime=" + uploadTime + "]";
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

}
