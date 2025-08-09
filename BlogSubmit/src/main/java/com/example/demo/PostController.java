package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import repository.PostRepository;

@Controller
public class PostController {
	
	private final PostRepository repository;
	
	public PostController(PostRepository repository){
		this.repository=repository;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("posts",repository.findAll());
		return "index";
	}
	
}
