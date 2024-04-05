package com.lehungtin.springboot.myfirstwebapp.todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	
	static {
		todos.add(new Todo(1, "lehungtin11", "DevOps", LocalDateTime.now().plusYears(1), false));
		todos.add(new Todo(2, "lehungtin11", "AWS", LocalDateTime.now().plusYears(2), false));
	}
	
	public List<Todo> findByName(String name) {
		return todos;
	}
}
