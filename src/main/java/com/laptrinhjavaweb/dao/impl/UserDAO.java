package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNamAndPasswordAndStatus(String userName, String password, Integer status) {
		String sql = "SELECT * from user AS u INNER JOIN role AS r ON r.id = u.roleid WHERE username = ? AND password = ? AND status= ?";
		List<UserModel> users = query(sql, new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

}
