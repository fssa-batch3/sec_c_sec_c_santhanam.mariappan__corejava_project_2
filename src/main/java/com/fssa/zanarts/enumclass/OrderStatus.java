package com.fssa.zanarts.enumclass;

public enum OrderStatus {
	ORDERED ("ORDERED"),
	SHIPPED("SHIPPED"),
	DELIVERED("DELIVERED"),
	CANCELLED("CANCELLED");
	
	String value;

	// Constructor to initialize the enum constants with values
	OrderStatus(String value) {
		this.value = value;
	} 

	// Getter method to retrieve the value of the enum constant
	public String getValue() {
		return value;
	};

	/**
	 * Get the name of the art type.
	 *
	 * @return The name of the art type.
	 */
}
