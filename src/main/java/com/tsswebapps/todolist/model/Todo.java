package com.tsswebapps.todolist.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Todo {
	private Long id;
	private String descricao;
	private LocalDateTime dataHoraMarcada;
	private Categorias categoria;
	private Situacao situacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataHoraMarcada() {
		return dataHoraMarcada;
	}

	public void setDataHoraMarcada(LocalDateTime dataHoraMarcada) {
		this.dataHoraMarcada = dataHoraMarcada;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, dataHoraMarcada, descricao, id, situacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return categoria == other.categoria && Objects.equals(dataHoraMarcada, other.dataHoraMarcada)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& situacao == other.situacao;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", descricao=" + descricao + ", dataHoraMarcada=" + dataHoraMarcada + ", categoria="
				+ categoria + ", situacao=" + situacao + "]";
	}

}
