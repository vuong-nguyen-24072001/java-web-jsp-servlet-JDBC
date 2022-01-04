package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserService {
	UserModel findByUserNamAndPasswordAndStatus(String userName, String password, Integer status);
}
