package com.tsswebapps.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tsswebapps.todolist.dto.FormTodoDto;
import com.tsswebapps.todolist.model.Situacao;
import com.tsswebapps.todolist.model.Todo;
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
	
	@PostMapping("/salvar")
	public ModelAndView cadastrar(FormTodoDto dtoTodo) {
		
		System.out.println(dtoTodo);
		
		/*
		 * if(result.hasErrors()) { ModelAndView mvError = new
		 * ModelAndView("todo/cadastrar"); mvError.addObject("mensagem",
		 * "Verifique os dados e tente novamente"); return mvError; }
		 */
		
		Todo todo = dtoTodo.toTodo();
		service.salvar(todo);
		
		return new ModelAndView("index");
	}
}
