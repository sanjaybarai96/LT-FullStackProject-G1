package com.lt.crs.dao;

import java.util.List;

import com.lt.crs.bean.User;

public interface UserDao {

	
	User getUser(String username);
	List<User> getAllUser();
	List<User> getAllStudentUser();
	void saveUser(String username, String password);
}
