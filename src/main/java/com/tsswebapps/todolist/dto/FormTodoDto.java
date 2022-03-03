package com.tsswebapps.todolist.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.tsswebapps.todolist.model.Categorias;
import com.tsswebapps.todolist.model.Situacao;
import com.tsswebapps.todolist.model.Todo;

public class FormTodoDto {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
	
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//@NotBlank
	private String descricao;
	
	//@NotNull
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	private String dataHoraMarcada;
	
	//@NotNull
	private Categorias categoria;
	
	public Todo toTodo() {
		Todo todo = new Todo();
		todo.setId(this.id);
		todo.setDescricao(this.descricao);
		todo.setDataHoraMarcada(LocalDate.parse(this.dataHoraMarcada, formatter));
		todo.setCategoria(this.categoria);
		todo.setSituacao(Situacao.PENDENTE);
		return todo;
	}

	public String getDataHoraMarcada() {
		return dataHoraMarcada;
	}

	public void setDataHoraMarcada(String dataHoraMarcada) {
		this.dataHoraMarcada = dataHoraMarcada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "FormTodoDto [descricao=" + descricao + ", dataHoraMarcada=" + dataHoraMarcada + ", categoria="
				+ categoria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, dataHoraMarcada, descricao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormTodoDto other = (FormTodoDto) obj;
		return categoria == other.categoria && Objects.equals(dataHoraMarcada, other.dataHoraMarcada)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id);
	}

}
