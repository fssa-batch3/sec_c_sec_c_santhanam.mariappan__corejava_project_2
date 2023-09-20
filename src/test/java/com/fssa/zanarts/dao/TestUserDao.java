package com.fssa.zanarts.dao;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.customexception.UserException;
import com.fssa.zanarts.enumclass.Role;
import com.fssa.zanarts.model.User;

public class TestUserDao {
	// Create a valid Product for testing purposes

	public static User validUser() {
		User user = new User();
		user.setUserName("Santhu");
		user.setId(1);
		user.setEmail("bharuchan@gmail.com");
		user.setPassword("Santhu@123");
		user.setPhoneNumber("9095297688");
		user.setRole(Role.ARTIST);

		return user;

	}

	// Create an invalid user for negative testing
 
	User invalidUser() {
		User user = new User();
		user.setId(2);
		user.setUserName("Santhanam");
		user.setEmail(".com");
		user.setPassword("Sa123");
		user.setPhoneNumber("909527688");
		user.setRole(Role.ARTIST);

		return user;

	}

	// Test the 'addUser' method with a valid Product
	@Test
	void testValidAddUser() throws SQLException, UserException {
		Assertions.assertTrue(UserDao.addUser(validUser()));
	}

	@Test
	void testValidUpdateUser() throws SQLException, UserException {
		Assertions.assertTrue(UserDao.updateUser(validUser(), 1));
	}

}
