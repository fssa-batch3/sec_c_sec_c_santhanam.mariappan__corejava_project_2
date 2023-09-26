package com.fssa.zanarts.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.UserException;
import com.fssa.zanarts.model.User;

public class UserValidator {
	public static boolean validate(User user) throws UserException {

		if (user == null) {
			throw new UserException(CustomErrors.USER_NULL);
		}
		validateUserName(user.getUserName());
		validatePhoneNumber(user.getPhoneNumber());
		validatePassword(user.getPassword());
		validateEmail(user.getEmail());
		
		return true;

	}
 
	
	public static boolean validateUpdate(User user) throws UserException {

		if (user == null) {
			throw new UserException(CustomErrors.USER_NULL);
		}
		validateUserName(user.getUserName());
		validatePhoneNumber(user.getPhoneNumber());
	
		
		
		
		return true;

	}
	public static boolean validateUserName(String userName) throws UserException {
		if (userName == null ||userName.trim().isEmpty()) {
			throw new UserException(CustomErrors.USER_NAME_NULL);
		}

		String nameregex = "^[A-Za-z]{3,50}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(userName);
		Boolean isMatch = matcher.matches();

		if (isMatch) {
			return true;
		} else {
			throw new UserException(CustomErrors.INVALID_USER_NAME_LENGTH);
		}

	}

//validation phone number
	public static boolean validatePhoneNumber(String phoneNumber) throws UserException {
		if (phoneNumber == null || "".equals(phoneNumber.trim())) {
			throw new UserException(CustomErrors.PHONE_NUMBER_NULL);
		}
 
		// Define a regex pattern for a valid phone number
		String phoneRegex = "^[0-9]{10}$"; // Assumes a 10-digit numeric phone number
		Pattern pattern = Pattern.compile(phoneRegex);
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean isMatch = matcher.matches();

		if (isMatch) {
			return true; 
		} else {
			throw new UserException(CustomErrors.PHONE_NUMBER_LENGTH);
		}
	}

	public static boolean validatePassword(String password) throws UserException {
		if (password == null || "".equals(password.trim())) {
			throw new UserException(CustomErrors.PASSWORD_NULL);
		}

		// Define a regex pattern for a valid password
		// Password must contain at least one uppercase letter, one lowercase letter,
		// one digit, and be at least 8 characters long.
		String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
		Pattern pattern = Pattern.compile(passwordRegex);
		Matcher matcher = pattern.matcher(password);
		boolean isMatch = matcher.matches();

		if (isMatch) {
			return true;
		} else {
			throw new UserException(CustomErrors.INVALID_PASSWORD_LENGTH);
		}
	}

//	email

	public static boolean validateEmail(String email) throws UserException {
		if (email == null || email.trim().isEmpty()) {
			throw new UserException(CustomErrors.INVALID_EMAIL);
		}

		// Define a regex pattern for a valid email address
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		boolean isMatch = matcher.matches();

		if (isMatch) {
			return true;
		} else {
			throw new UserException(CustomErrors.INVALID_EMAIL);
		}
	}

}
