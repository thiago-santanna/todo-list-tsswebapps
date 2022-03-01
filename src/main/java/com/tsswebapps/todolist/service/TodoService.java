package com.tsswebapps.todolist.service;

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
	
	public List<Todo> listarTodosPorCategoria(Categorias categoria) {
		return null;
	}
	
	public Todo salvar(Todo todo) {
		return repository.save(todo);
	}
	
}
