package com.lt.crs.application;

import com.lt.crs.bean.User;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.Menu;
import com.lt.crs.service.UserService;
import com.lt.crs.service.UserServiceInterface;
import com.lt.crs.utils.Utils;

public class CrsProfessorMenu {

	private UserServiceInterface userService = new UserService();
	
	public void createMenu(User userObj) {
		boolean isExit = false;
		while(!isExit) {
			Utils.printStatement(String.format(Menu.ProfessorMenu,Menu.LogOut));
			InputConstants.optionNumber = InputConstants.sc.nextInt();
			switch (InputConstants.optionNumber) {
			case 1:
				//add grades method
				break;
			case 2:
				//add view enrolled students 
				System.out.println("work in progress");
				break;
			case 3:
				//add courses to teach
				System.out.println("work in progress");
				break;
			case 4:
				userObj = userService.userLogout(userObj);
				isExit = true;
				break;
			default:
				break;
			}
		}


	}
}
