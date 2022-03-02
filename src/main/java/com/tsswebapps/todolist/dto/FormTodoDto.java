package com.tsswebapps.todolist.dto;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import com.tsswebapps.todolist.model.Categorias;
import com.tsswebapps.todolist.model.Situacao;
import com.tsswebapps.todolist.model.Todo;

public class FormTodoDto {
	
	//@NotBlank
	private String descricao;
	
	//@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataHoraMarcada;
	
	//@NotNull
	private Categorias categoria;
	
	public Todo toTodo() {
		Todo todo = new Todo();
		todo.setDescricao(this.descricao);
		todo.setDataHoraMarcada(this.dataHoraMarcada);
		todo.setCategoria(this.categoria);
		todo.setSituacao(Situacao.PENDENTE);
		return todo;
	}

	public LocalDate getDataHoraMarcada() {
		return dataHoraMarcada;
	}

	public void setDataHoraMarcada(LocalDate dataHoraMarcada) {
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
		return Objects.hash(categoria, dataHoraMarcada, descricao);
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
				&& Objects.equals(descricao, other.descricao);
	}

}
