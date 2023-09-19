package com.fssa.zanarts.service;

import java.sql.SQLException;

import com.fssa.zanarts.customexception.DAOException;
import com.fssa.zanarts.customexception.UserException;
import com.fssa.zanarts.dao.UserDao;
import com.fssa.zanarts.logger.Logger;
import com.fssa.zanarts.model.User;
import com.fssa.zanarts.validator.UserValidator;

public class UserService {
	static Logger log = new Logger();

	public static boolean addUser(User user) throws SQLException, UserException {
		System.out.println(user.toString());
		if (UserValidator.validate(user)) {
			UserDao.addUser(user);
			log.info("Added to DB successfully!");
		}

		return true;
	}

//	update 
	public static boolean updateUser(User user) throws SQLException, UserException, DAOException {
		if (UserValidator.validate(user)) {
			UserDao.updateUser(user);
		}
		log.info("Sucessfully User Details update");
		return true;
	}

//	login
	public User login(String email, String password) throws DAOException, SQLException {
		return UserDao.login(email, password);
	}

	 
}
