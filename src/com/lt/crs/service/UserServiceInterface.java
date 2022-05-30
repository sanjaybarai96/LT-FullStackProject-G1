package com.lt.crs.service;

import com.lt.crs.bean.User;

public interface UserServiceInterface {

	public User userLogin();
	public User userLogout(User user);
	public void registerUser(int isApproved);
	public void resetPassword();
	public void updatePassword();
}
