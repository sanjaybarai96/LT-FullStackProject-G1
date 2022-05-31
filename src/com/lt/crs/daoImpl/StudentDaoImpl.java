package com.lt.crs.daoImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.lt.crs.bean.Student;
import com.lt.crs.constants.DataCollections;
import com.lt.crs.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getStudentsByCourseName(List<String> courses) {
		
		return DataCollections.students.stream()
				.filter(student-> courses.stream().filter(course->student.getCourse().contains(course)).findAny().isPresent())
				.collect(Collectors.toList());
	}

	
}
