package com.fssa.zanarts.customexception;

/**
 * Custom exception class to handle specific exceptions in the Zanarts project.
 */

	public class ProductExpection extends Exception {
		
		  /**
	     * Constructs a new CustomException with the specified detail message.
	     *
	     * @param message The detail message.
	     */

		private static final long serialVersionUID = -8105491977357554060L;

		public  ProductExpection(String s) {
			super(s);
		}

		public ProductExpection(Throwable te) {
			super(te);
		}

		public ProductExpection(String s, Throwable te) {
			super(s, te);
		}

	}
 

