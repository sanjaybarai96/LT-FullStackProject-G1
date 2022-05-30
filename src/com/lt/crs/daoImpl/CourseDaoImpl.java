package com.lt.crs.daoImpl;

import java.util.List;

import com.lt.crs.bean.Course;
import com.lt.crs.constants.DataCollections;
import com.lt.crs.dao.CourseDao;

public class CourseDaoImpl implements CourseDao{

	@Override
	public void saveCourse(Course course) {
		DataCollections.courses.add(course);
	}

	@Override
	public List<Course> getAllCourse() {
		return DataCollections.courses;
	}

}
