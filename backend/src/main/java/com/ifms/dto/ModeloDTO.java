package com.ifms.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.ifms.entities.Marca;
import com.ifms.entities.Modelo;

public class ModeloDTO {

	private Long id;
	private String descricao;
	private Marca marca;

	public ModeloDTO(Long id, String descricao, Marca marca) {
		this.id = id;
		this.descricao = descricao;
		this.marca = marca;
	}

	public ModeloDTO(Modelo entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.marca = entity.getMarca();
	}

	public ModeloDTO() {
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

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public static List<ModeloDTO> converter(List<Modelo> list) {
		return list.stream().map(ModeloDTO::new).collect(Collectors.toList());
	}
	
	
	
}
