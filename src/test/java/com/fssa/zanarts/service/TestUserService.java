package com.fssa.zanarts.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.zanarts.customexception.DAOException;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.customexception.UserException;
import com.fssa.zanarts.enumclass.Role;
import com.fssa.zanarts.model.User;

public class TestUserService {

	static User validUser() {
		User user = new User();
		user.setUserName("Kingstan");
		user.setId(1);
		user.setEmail("king@gmail.com");
		user.setPassword("Santhu@123");
		user.setPhoneNumber("9095297688");
		user.setRole(Role.ARTIST);

		return user;
	}

	/**
	 * Test adding a valid User.
	 *
	 * @throws CustomExpection If a custom exception occurs.
	 * @throws SQLException    If an SQL exception occurs.
	 * @throws UserException
	 */
	@Test
	void testValidAddUser() throws SQLException, UserException {

		TestUserService testUser = new TestUserService();
		Assertions.assertTrue(UserService.addUser(validUser()));
	}
 
	
	/**
	 * Test update User
	 *
	 * @throws CustomExpection  If a custom exception occurs.
	 * @throws SQLException     If an SQL exception occurs.
	 * @throws UserException
	 * @throws DAOException 
	 */

	
	@Test
	void testValidUpdateUser() throws UserException, SQLException, DAOException {
		TestUserService testUser = new TestUserService();

		Assertions.assertTrue(UserService.updateUser(validUser()));
	}

}
