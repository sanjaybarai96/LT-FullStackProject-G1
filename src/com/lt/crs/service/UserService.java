package com.lt.crs.service;

import com.lt.crs.bean.User;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.DataCollections;
import com.lt.crs.dao.UserDao;
import com.lt.crs.daoImpl.UserDaoImpl;
import com.lt.crs.utils.Utils;

public class UserService implements UserServiceInterface{
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User userLogin() {
		boolean credentialCheck = true;
		User userObj = null;
		while(credentialCheck) {
			Utils.printStatement("Enter Username");
			String username = InputConstants.sc.next();
			Utils.printStatement("Enter Password");
			String password = InputConstants.sc.next();
			userObj = userDao.getUser(username);
			if(checkingCredentials(userObj,username,password)) {
//				userObj = UsersList.users.stream()
//						.filter(user->user.getUserName().equals(username))
//						.findFirst().get();
				credentialCheck = false;
			}
		}
		Utils.printStatement("User successfully logged in");
		userObj.setSession(true);
		return userObj;
	}

	@Override
	public void registerUser() {

		Utils.printStatement("Registeration form");
		boolean isUserExist = true;
		String username = "";
		while(isUserExist) {
			Utils.printStatement("Enter Username");
			username = InputConstants.sc.next();
			if(!isUsernameExist(username))
				isUserExist = false;
			else
				Utils.printStatement("Username exist. Try with another username");
		}
		Utils.printStatement("Enter Password");
		String password = InputConstants.sc.next();
		userDao.saveUser(username,password);
		Utils.printStatement("User Register successfully");
	}

	@Override
	public void resetPassword() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword() {
		// TODO Auto-generated method stub

	}

	private boolean checkingCredentials(User user,String username, String password) {
		if(user!=null) {
			if(user.getPassword().equals(password))
				return true;
			else {
				System.out.println("Password does not match");
				return false;
			}
		}else {
			System.out.println("User not found");
			return false;
		}
	}

	private boolean isUsernameExist(String username) {
		return DataCollections.users.stream().map(User :: getUserName)
				.anyMatch(existUsername -> existUsername.equals(username));
	}

	@Override
	public User userLogout(User user) {
		user.setSession(false);
		return user;
	}

}
