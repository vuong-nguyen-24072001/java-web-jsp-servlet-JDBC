package com.laptrinhjavaweb.service.impl;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserModel findByUserNamAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNamAndPasswordAndStatus(userName, password, status);
	}

}
