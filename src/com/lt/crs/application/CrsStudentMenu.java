package com.lt.crs.application;

import com.lt.crs.bean.User;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.Menu;
import com.lt.crs.utils.Utils;

public class CrsStudentMenu {
	static String input;
	
	public void createMenu(User user) {
		if(user.getIsApprove() == 0) {
			Utils.printStatement("Wait for you account to be approval by admin");
			Utils.printStatement("1."+Menu.LogOut);
			input = InputConstants.sc.next();
		}else {
			Utils.printStatement(String.format(Menu.StudentMenu, Menu.LogOut));
			input = InputConstants.sc.next();
		}
	}
}
