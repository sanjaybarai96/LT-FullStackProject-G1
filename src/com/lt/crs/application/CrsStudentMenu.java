package com.lt.crs.application;

import com.lt.crs.bean.User;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.Menu;
import com.lt.crs.service.UserService;
import com.lt.crs.service.UserServiceInterface;
import com.lt.crs.utils.Utils;

public class CrsStudentMenu {
	
	private UserServiceInterface userService = new UserService();
	
	/*
	 * Student menu
	 * @params user
	 */
	public void createMenu(User user) {
		if(user.getIsApprove() == 0) {
			Utils.printStatement("Wait for you account to be approval by admin");
			Utils.printStatement("1."+Menu.LogOut);
			InputConstants.optionNumber = InputConstants.sc.nextInt();
			userService.userLogout(user);
		}else {
			Utils.printStatement(String.format(Menu.StudentMenu, Menu.LogOut));
			InputConstants.optionNumber = InputConstants.sc.nextInt();
			switch (InputConstants.optionNumber) {
			case 1:
				//view catalog
				break;
			case 2:
				//Course registration
				break;
			case 3:
				//Add course
				break;
			case 4:
				//Drop course
				break;
			case 5:
				//View Grades
				break;
			case 6:
				//Pay Fee
				break;
			case 7:
				userService.userLogout(user);
				break;
				

			default:
				break;
			}
		}
	}
}
