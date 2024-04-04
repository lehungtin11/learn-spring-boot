package com.lehungtin11.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(
				new Course(1, "Learn AWS", "lehungtin11"),
				new Course(2, "Learn DevOps", "lehungtin11"),
				new Course(3, "Learn C#", "lehungtin11")
				);
	}
}
