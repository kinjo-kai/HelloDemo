package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;

@Controller
public class TodoController {
	
	private final TodoRepository repository;
	
	public TodoController(TodoRepository repository) {
		this.repository= repository;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("todos",repository.findAll());
		model.addAttribute("newTodo",new Todo());
		return "index";
	}
	@PostMapping("/add")
	public String add(@ModelAttribute Todo todo) {
		repository.save(todo);
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/complete/{id}")
	public String complete(@PathVariable Long id) {
		Todo todo= repository.findById(id).orElseThrow();
		todo.setCompleted(true);
		repository.save(todo);
		return "redirect:/";
	}
}
