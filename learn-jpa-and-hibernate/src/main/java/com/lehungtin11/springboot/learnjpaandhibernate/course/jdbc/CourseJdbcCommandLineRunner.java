package com.lehungtin11.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lehungtin11.springboot.learnjpaandhibernate.course.Course;
import com.lehungtin11.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	CourseJdbcRepository repository;
	
//	@Autowired
//	CourseJpaRepository repository;
	
	@Autowired
	CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Lehungtin11", "Description"));
		repository.save(new Course(2, "TinhTinTang", "Description"));
		repository.save(new Course(3, "TinhTinTang2", "Description"));
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findByName("TinhTinTang2"));
	}

}
