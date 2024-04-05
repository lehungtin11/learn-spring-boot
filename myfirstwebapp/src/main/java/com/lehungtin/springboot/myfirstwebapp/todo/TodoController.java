package com.lehungtin.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {
	TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@RequestMapping("list-todos")
	public String goTodoList(ModelMap model) {
		List<Todo> todos = todoService.findByName("lehungtin11");
		
		model.addAttribute("todos", todos);
		
		return "listTodos";
	}
	
}
