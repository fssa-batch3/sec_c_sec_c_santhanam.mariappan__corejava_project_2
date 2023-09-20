package com.fssa.zanarts.customexception;

public class OrderException extends Exception {

	/**
	 * Constructs a new CustomException with the specified detail message.
	 *exception
	 * @param message The detail message.
	 */

	private static final long serialVersionUID = -8105491977357554060L;

	public OrderException(String s) {
		super(s);
	}

	public OrderException(Throwable te) {
		super(te);
	}

	public OrderException(String s, Throwable te) {
		super(s, te);
	}

}
