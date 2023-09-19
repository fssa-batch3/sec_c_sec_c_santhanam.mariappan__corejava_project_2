package com.fssa.zanarts.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.customexception.UserException;
import com.fssa.zanarts.enumclass.Role;
import com.fssa.zanarts.model.User;

public class TestUserValidator {
	@Test
	void testValidate() throws UserException {
		try {

			User user = new User();
			user.setUserName("Santhu");
			user.setEmail("bharuchan@gmail.com");
			user.setPassword("Santhu@123");
			user.setRole(Role.ARTIST);

			UserValidator uservalidator = new UserValidator();
			Assertions.assertTrue(uservalidator.validate(user));
		} catch (UserException ex) {
			ex.getMessage();
		}
	}

	@Test
	void inValidTestValidate() throws UserException {
		UserValidator userValidator = new UserValidator();
		try {
			userValidator.validate(null);
		} catch (UserException ex) {
			Assertions.assertEquals(CustomErrors.USER_NULL, ex.getMessage());
		}

	}

	/** 
	 * Valid test case for user name validation.
	 * 
	 * @throws UserException
	 */
	@Test
	void testValidUserName() throws UserException {

		try {
			Assertions.assertTrue(UserValidator.validateUserName("Santhanam"));
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Invalid test case for null product name validation.
	 * 
	 * @throws UserException
	 */

	@Test
	void testInValiateNullUserName() throws UserException {

		try {
			UserValidator.validateUserName(null);
			Assertions.fail("Validation name failed");
		}

		catch (UserException ex) {
			Assertions.assertEquals(CustomErrors.USER_NAME_NULL, ex.getMessage());
		}
	}

	/**
	 * Validation for valid Description
	 * 
	 * @throws UserException
	 **/
	@Test

	void testValidPassword() throws UserException {
		try {
			Assertions.assertTrue(UserValidator.validatePassword("Santhu@2003"));
		} catch (UserException e) {
			e.getMessage();
		}

	}

	/*
	 * Invalid validator for password
	 */

	@Test
	void testInValidNullpassword() throws UserException {
		try {
			UserValidator.validatePassword(null);

			Assertions.fail(" Description validation name failed");

		} catch (UserException ex) {

			Assertions.assertEquals(CustomErrors.PASSWORD_NULL, ex.getMessage());
		}
	}

	/*
	 * Invalid validator for Password
	 */

	@Test
	void testInValidLengthPassword() throws UserException {
		try {
			UserValidator.validatePassword("df");

			Assertions.fail("Password validation name failed");

		} catch (UserException ex) {

			Assertions.assertEquals(CustomErrors.INVALID_PASSWORD_LENGTH, ex.getMessage());
		}
	}

	/*
	 * valid testcase for ph num
	 */

	@Test
	void testValidprice() throws UserException {
		Assertions.assertTrue(UserValidator.validatePhoneNumber("9095297688"));
	}

	/*
	 * Invalid validator for Phone number
	 */
 
	@Test
	void testInValidPhonenumber() throws UserException {
		try {
			UserValidator.validatePhoneNumber(null);

			Assertions.fail("Phone number validation name failed");

		} catch (UserException ex) {

			Assertions.assertEquals(CustomErrors.PHONE_NUMBER_NULL, ex.getMessage());
		}
	}

	/*
	 * Invalid validator for Password
	 */

	@Test
	void testInValidLengthPhonenumber() throws UserException {
		try {
			UserValidator.validatePhoneNumber("90");

			Assertions.fail("Phone number validation  failed");

		} catch (UserException ex) {

			Assertions.assertEquals(CustomErrors.PHONE_NUMBER_LENGTH, ex.getMessage());
		}
	}

}
