package com.tsswebapps.todolist.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tsswebapps.todolist.dto.FormTodoDto;
import com.tsswebapps.todolist.model.Categorias;
import com.tsswebapps.todolist.model.Todo;
import com.tsswebapps.todolist.service.TodoService;

@Controller
@RequestMapping("/")
public class TodoController {
	
	private final String CADASTRO = "cadastro";

	private TodoService service;

	public TodoController(TodoService todoService) {
		this.service = todoService;
	}
	
    @ModelAttribute("todasCategorias")
    public List<Categorias> todasCategorias(){
    	return Arrays.asList(Categorias.values());
    }

	@GetMapping()
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");		
		List<Todo> selecaoTodos = service.todosByDay(LocalDate.now());
		mv.addObject("localDate", LocalDate.now());
		mv.addObject("selecaoTodos", selecaoTodos);
		return mv;
	}
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView(CADASTRO);
		Todo todo = new Todo();
		mv.addObject("todo", todo);		
		return mv;
	}

	@PostMapping("/salvar")
	public String cadastrar(FormTodoDto dtoTodo, RedirectAttributes attributes) {
		Todo todo = dtoTodo.toTodo();

		service.salvar(todo);
		attributes.addFlashAttribute("mensagem", "Sua nova tarefa foi salva.");
		return "redirect:/cadastrar";
	}

	@GetMapping("/category/{categoria}") 
	public ModelAndView findByCategoria(@PathVariable String categoria) {	  
	  List<Todo> selecaoTodos = service.listarTodosPorCategoria(Categorias.valueOf(categoria.toUpperCase()));  
	  ModelAndView mv = new ModelAndView("index"); 	  
	  mv.addObject("selecaoTodos", selecaoTodos);
	  return mv;
	}
	
	@GetMapping("/altera/{id}") 
	public ModelAndView alterar(@PathVariable Long id) {	  
	  Todo todo = service.findBiId(id); 
	  ModelAndView mv = new ModelAndView(CADASTRO);
	  mv.addObject("todo", todo);
	  return mv;
	}
	
	@GetMapping("/apaga/{id}") 
	public String apagar(@PathVariable Long id) {	  
	  service.apagar(id);  
	  return "redirect:/";
	}
	
	@GetMapping("/finaliza/{id}")
	public String finalizar(@PathVariable Long id) {
		Todo todo = service.finalizaTodo(id);
		service.salvar(todo);
		return "redirect:/";
	}

}
