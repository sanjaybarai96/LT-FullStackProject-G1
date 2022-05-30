package com.lt.crs.service;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Professor;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.dao.ProfessorDao;
import com.lt.crs.daoImpl.ProfessorDaoImpl;

public class ProfessorService implements ProfessorServiceInterface{

	private ProfessorDao professorDao = new ProfessorDaoImpl();
			
	@Override
	public void addProfessor() {
		boolean isExit = false;
		while(!isExit) {
			Professor professor = new Professor(); 
			System.out.println("Enter the course code");
			professor.setName(InputConstants.sc.next());
			System.out.println("Enter the course name");
			professor.setCourseCode(InputConstants.sc.next());

			professorDao.saveProfessor(professor);

			System.out.println("Press 1 to exit or if you want to continue to add new course press 2");
			if(InputConstants.sc.nextInt()==1) {
				isExit = true;
			}
		}		
	}

}
