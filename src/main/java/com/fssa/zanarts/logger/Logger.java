package com.fssa.zanarts.logger;

public class Logger {
	// Private constructor to hide the implicit public one
	public Logger() {
		// Private constructor to prevent instantiation
	}

	/**
	 * Logs the provided object's string representation to the console as an
	 * information message.
	 *
	 * @param obj The object to log.
	 */
	public static void info(Object obj) {
		System.out.println(obj);
	}
}
