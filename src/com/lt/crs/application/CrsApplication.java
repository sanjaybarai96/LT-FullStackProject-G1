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
					break;
				case Professor:
					crsProfessorMenu.createMenu(userObj);
					break;
				case Admin:
					crsAdminMenu.createMenu(userObj);
					break;

				default:
					break;
				}
			}

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
}

