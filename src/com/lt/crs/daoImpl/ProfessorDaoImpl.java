package com.lt.crs.daoImpl;

import com.lt.crs.bean.Professor;
import com.lt.crs.constants.DataCollections;
import com.lt.crs.dao.ProfessorDao;

public class ProfessorDaoImpl implements ProfessorDao{

	@Override
	public void saveProfessor(Professor professor) {
		DataCollections.professors.add(professor);
	}

}
