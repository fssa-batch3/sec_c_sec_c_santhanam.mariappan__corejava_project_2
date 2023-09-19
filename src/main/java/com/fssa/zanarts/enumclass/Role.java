package com.fssa.zanarts.enumclass;

public enum Role {
	BUYER("buyer"), ARTIST("artist");

	String value;

	// Constructor to initialize the enum constants with values
	Role(String value) {
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
	public String getRole() {
		return this.name();
	}
}
