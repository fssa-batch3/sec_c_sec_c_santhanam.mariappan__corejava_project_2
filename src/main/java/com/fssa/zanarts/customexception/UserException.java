package com.fssa.zanarts.customexception;

/**
 * Custom exception class to handle specific exceptions in the Zanarts project.
 */

	public class UserException extends Exception {
		
		  /**
	     * Constructs a new CustomException with the specified detail message.
	     *
	     * @param message The detail message.
	     */

		private static final long serialVersionUID = -8105491977357554060L;

		public  UserException(String s) {
			super(s);
		}

		public UserException(Throwable te) {
			super(te);
		}

		public UserException(String s, Throwable te) {
			super(s, te);
		}

	}
 

