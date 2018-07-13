package com.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String nome;
	private Double preço;
	
	
	//Associação entre Produto e categorias
	@JsonBackReference
	@ManyToMany
	@JoinTable(name= "PRODUTO_CATEGORIA",
		joinColumns= @JoinColumn(name = "produto_id"),
		inverseJoinColumns= @JoinColumn(name = "categori_id")
	)
	
	private List<Categoria> categorias = new ArrayList<>();
	
	public Produto() {	
	}
	

	public Produto(Integer id, String nome, Double preço) {
		super();
		Id = id;
		this.nome = nome;
		this.preço = preço;
	}


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPreço() {
		return preço;
	}


	public void setPreço(Double preço) {
		this.preço = preço;
	}


	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
		
		


		
		
		
		
}
