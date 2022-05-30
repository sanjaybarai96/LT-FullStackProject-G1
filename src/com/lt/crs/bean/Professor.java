package com.lt.crs.bean;

public class Professor {
	
	private String name;
	private String courseCode;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	@Override
	public String toString() {
		return "Professor [name=" + name + ", courseCode=" + courseCode + "]";
	}

	
}
