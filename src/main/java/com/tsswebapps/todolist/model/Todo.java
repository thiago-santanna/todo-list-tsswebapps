package com.tsswebapps.todolist.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "todos")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100)
	private String descricao;
	
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataHoraMarcada;
	
	@Enumerated(EnumType.STRING)
	private Categorias categoria;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	public boolean isPendente() {
		return Situacao.PENDENTE.equals(this.situacao);
	}

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

	public LocalDate getDataHoraMarcada() {
		return dataHoraMarcada;
	}

	public void setDataHoraMarcada(LocalDate dataHoraMarcada) {
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
