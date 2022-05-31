package com.lt.crs.bean;

import java.util.UUID;

public class Student {

	private UUID studentId;
	private String course;
	
	public UUID getStudentId() {
		return studentId;
	}
	public void setStudentId(UUID studentId) {
		this.studentId = studentId;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
}
