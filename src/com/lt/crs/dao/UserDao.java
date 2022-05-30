package com.lt.crs.dao;

import java.util.List;

import com.lt.crs.bean.User;
import com.lt.crs.constants.Role;

public interface UserDao {

	
	User getUser(String username);
	List<User> getAllUser();
	List<User> getAllStudentUser();
	void saveUser(String username, String password,int isApproved,Role role);
}
