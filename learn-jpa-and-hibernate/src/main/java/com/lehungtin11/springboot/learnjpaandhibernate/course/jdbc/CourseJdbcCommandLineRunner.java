package com.lehungtin11.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	CourseJdbcResponsitory courseJdbcResponsitory;

	@Override
	public void run(String... args) throws Exception {
		courseJdbcResponsitory.Insert();
	}
	
}
