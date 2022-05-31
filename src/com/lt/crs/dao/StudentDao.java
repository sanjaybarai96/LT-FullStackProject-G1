package com.lt.crs.dao;

import java.util.List;

import com.lt.crs.bean.Student;

public interface StudentDao {

//	List<Student> getAllStudents();
	List<Student> getStudentsByCourseName(List<String> course);
}
