package com.lehungtin11.springboot.learnspringboot;

public class Course {
	private long id;
	private String name;
	private String course;
	
	public Course(long id, String name, String course) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", course=" + course + "]";
	}
	
	
}
