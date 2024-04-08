package com.lehungtin11.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcResponsitory {
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY =
			"""
			insert into course (id, name, author) values (1, 'ABC', 'DEF');
			""";
	
	public void Insert() {
		springJdbcTemplate.update(INSERT_QUERY);
	}
}
