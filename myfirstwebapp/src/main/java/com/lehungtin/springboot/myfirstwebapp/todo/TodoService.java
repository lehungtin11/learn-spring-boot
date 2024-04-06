package com.lehungtin.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todoCount = 0;
	
	static {
		todos.add(new Todo(++todoCount, "lehungtin11", "DevOps", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "lehungtin11", "AWS", LocalDate.now().plusYears(2), false));
	}
	
	public List<Todo> findByName(String name) {
		return todos;
	}
	
	public void addTodo(String name, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todoCount, name, description, targetDate, done);
		todos.add(todo);
	}
}
