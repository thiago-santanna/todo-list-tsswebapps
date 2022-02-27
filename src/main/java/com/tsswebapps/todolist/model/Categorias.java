package com.tsswebapps.todolist.model;

public enum Categorias {
	
	URGENTE("Urgente"),
	TAREFA("Tarefa"),
	LAZER("Lazer"),
	FAMILIA("Família"),
	TRABALHO("Trabalho");
	
	private String descricao;

	Categorias(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
}
