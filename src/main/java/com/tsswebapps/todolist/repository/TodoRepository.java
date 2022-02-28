package com.tsswebapps.todolist.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsswebapps.todolist.model.Categorias;
import com.tsswebapps.todolist.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	List<Todo> findByCategoria(Categorias categoria);
	List<Todo> findByDataHoraMarcada(LocalDate dataHoraMarcada);
}
