package com.lt.crs.service;

import java.util.List;
import java.util.UUID;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.User;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.dao.UserDao;
import com.lt.crs.daoImpl.UserDaoImpl;

public class AdminService implements AdminServiceInterface{

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public void addProfessor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approveStudents() {
		List<User> students = userDao.getAllStudentUser();
		System.out.println("List of all unapproved student registration");
		if(students.size()>0) {
			boolean isExit = false;
			while(!isExit) {
				students.stream().filter(student->student.getIsApprove()==0).forEach(System.out::println);
				System.out.println("Enter the uuid for student approve");
				System.out.println("Type 1 to exit this window");
				InputConstants.input = InputConstants.sc.next();
				if(InputConstants.input.equals("1")) {
					isExit = true;
				}else {
					studentApproving(students,UUID.fromString(InputConstants.input.toString()));
				}
			}
		}
	}

	private void studentApproving(List<User> students, UUID input) {
		students.stream().filter(std->std.getUserId().equals(input))
						 .forEach(std->std.setIsApprove(1));
		
	}

	@Override
	public void generateReportCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourse() {
		
	}

}
