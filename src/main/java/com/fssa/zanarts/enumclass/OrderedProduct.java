package com.fssa.zanarts.enumclass;

public class OrderedProduct {
	private String name;
	private double price;
	private double totalAmount;
	private int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OrderedProduct(String name, double price, double totalAmount, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.totalAmount = totalAmount;
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderedProduct [productname=" + name + ", Price=" + price + ", quantity=" + quantity + ", totalAmount="
				+ totalAmount + "]";
	}
}
