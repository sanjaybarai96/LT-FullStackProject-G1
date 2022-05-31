package com.lt.crs.daoImpl;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public List<Course> getCourse(String instructorName) {
		return DataCollections.courses.stream().filter(course->course.getInstructor().equals(instructorName))
											   .collect(Collectors.toList());
	}

	@Override
	public List<String> getAllBranchesCourses() {
		return DataCollections.courseBranches;
		
	}

}
