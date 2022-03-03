package com.tsswebapps.todolist.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.todolist.model.Categorias;
import com.tsswebapps.todolist.model.Todo;
import com.tsswebapps.todolist.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;
	
	public Todo findBiId(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Todo> listarTodosPorCategoria(Categorias categoria) {
		return repository.findByCategoria(categoria);
	}
	
	public Todo salvar(Todo todo) {
		return repository.save(todo);
	}
	
	public List<Todo> todosByDay(LocalDate day){
		return repository.findByDataHoraMarcada(day);
	}
	
	public void apagar(Long id) {
		repository.deleteById(id);
	}
	
}
