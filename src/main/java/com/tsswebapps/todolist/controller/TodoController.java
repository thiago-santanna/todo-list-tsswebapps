package com.tsswebapps.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tsswebapps.todolist.service.TodoService;

@Controller
@RequestMapping("todo")
public class TodoController {
	
	private TodoService service;
	
	public TodoController(TodoService todoService) {
		this.service = todoService;
	}

	@GetMapping("/resumo")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("cadastro");
		return mv;
	}
}
