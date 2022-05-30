package com.lt.crs.daoImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.lt.crs.bean.User;
import com.lt.crs.constants.Role;
import com.lt.crs.constants.DataCollections;
import com.lt.crs.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUser(String username) {
		
		return DataCollections.users.stream()
			.filter(user->user.getUserName().equals(username)).findAny().orElse(null); 
	}

	@Override
	public void saveUser(String username, String password) {
		User user = new User();
		user.setUserId(UUID.randomUUID());
		user.setUserName(username);
		user.setPassword(password);
		user.setCreateDate(new Date());
		user.setIsApprove(0);
		user.setRole(Role.Student.name());
		user.setSession(false);
		DataCollections.users.add(user);
	}

	@Override
	public List<User> getAllUser() {
		return DataCollections.users;
	}

	@Override
	public List<User> getAllStudentUser() {
		List<User> students = DataCollections.users.stream()
											 .filter(user->user.getRole().equals(Role.Student.name()))
											 .collect(Collectors.toList());
		return students;
	}

}
