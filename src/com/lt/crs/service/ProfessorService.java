package com.lt.crs.service;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Professor;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.Role;
import com.lt.crs.dao.ProfessorDao;
import com.lt.crs.dao.UserDao;
import com.lt.crs.daoImpl.ProfessorDaoImpl;
import com.lt.crs.daoImpl.UserDaoImpl;

public class ProfessorService implements ProfessorServiceInterface{

	private ProfessorDao professorDao = new ProfessorDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	 
			
	@Override
	public void addProfessor() {
		boolean isExit = false;
		while(!isExit) {
			Professor professor = new Professor(); 
			System.out.println("Enter the principle name");
			professor.setName(InputConstants.sc.next());
			System.out.println("Enter the course code");
			professor.setCourseCode(InputConstants.sc.next());

			professorDao.saveProfessor(professor);
			userDao.saveUser(professor.getName(), "Admin@123", 1,Role.Professor);
			System.out.println("Press 1 to exit or if you want to continue to add new course press 2");
			if(InputConstants.sc.nextInt()==1) {
				isExit = true;
			}
		}		
	}

}
