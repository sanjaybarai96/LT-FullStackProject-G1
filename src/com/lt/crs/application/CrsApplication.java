package com.lt.crs.application;

import java.util.Date;
import java.util.UUID;

import com.lt.crs.bean.User;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.Menu;
import com.lt.crs.constants.Role;
import com.lt.crs.constants.DataCollections;
import com.lt.crs.service.UserService;
import com.lt.crs.service.UserServiceInterface;
import com.lt.crs.utils.Utils;

public class CrsApplication {
	static Role role;
	private static CrsAdminMenu crsAdminMenu = new CrsAdminMenu();
	private static CrsStudentMenu crsStudentMenu = new CrsStudentMenu();
	private static CrsProfessorMenu crsProfessorMenu = new CrsProfessorMenu();

	public static void main(String[] args) {
		loadAdmin();
		createMenu();
	}

	private static void createMenu() {
		boolean isExit = false;
		User userObj = null;
		UserServiceInterface userService = new UserService();

		while(!isExit) {
			Utils.printStatement(Menu.Title);
			Utils.printStatement(Menu.Options);
			Utils.printStatement(Menu.InitialMenu);
			InputConstants.optionNumber = InputConstants.sc.nextInt();

			switch (InputConstants.optionNumber) {
			case 1:
				userObj = userService.userLogin();
				break;
			case 2:
				userService.registerUser(0);
				break;
			case 3:
				userService.updatePassword();
				break;
			case 4:
				isExit = true;
				break;

			default:
				Utils.printStatement("Please enter proper options");
				break;
			}

			if(userObj!=null && userObj.getSession()) {
				Utils.printStatement(String.format(Menu.WeclomeMsg,userObj.getUserName()));
				switch (Role.valueOf(userObj.getRole())) {
				case Student:
					crsStudentMenu.createMenu(userObj);
					//studentProcess(userObj);
					break;
				case Professor:
					crsProfessorMenu.createMenu(userObj);
					break;
				case Admin:
					crsAdminMenu.createMenu(userObj);
					//admin Process(userObj);
					break;

				default:
					break;
				}
			}

		}
	}


	private static void adminProcess(User userObj) {
		Utils.printStatement(Menu.AdminMenu);
		InputConstants.optionNumber = InputConstants.sc.nextInt();
		switch (InputConstants.optionNumber) {
		case 4:
			approveStudentRegistration();

			break;

		default:
			break;
		}

	}


	private static void approveStudentRegistration() {
		// TODO Auto-generated method stub

	}


	private static void studentProcess(User userObj) {
		if(userObj.getIsApprove() == 0) {
			Utils.printStatement("Wait for you account to be approval by admin");
			Utils.printStatement("1."+Menu.LogOut);
			InputConstants.input = InputConstants.sc.next();
		}else {
			Utils.printStatement(String.format(Menu.StudentMenu, Menu.LogOut));
			InputConstants.input = InputConstants.sc.next();
		}

	}


	private static void loadAdmin() {
		User user = new User();
		user.setUserId(UUID.randomUUID());
		user.setUserName("admin");
		user.setPassword("admin");
		user.setCreateDate(new Date());
		user.setRole(Role.Admin.name());
		user.setIsApprove(1);
		DataCollections.users.add(user);
	}

	private static void registeringAccount() {
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
		addingUserDetails(username,password);
		Utils.printStatement("User Register successfully");
	}


	private static boolean isUsernameExist(String username) {
		return DataCollections.users.stream().map(User :: getUserName)
				.anyMatch(existUsername -> existUsername.equals(username));
	}


	private static void addingUserDetails(String username, String password) {
		User user = new User();
		user.setUserId(UUID.randomUUID());
		user.setUserName(username);
		user.setPassword(password);
		user.setCreateDate(new Date());
		user.setIsApprove(0);
		user.setRole(Role.Student.name());
		DataCollections.users.add(user);
	}
}

