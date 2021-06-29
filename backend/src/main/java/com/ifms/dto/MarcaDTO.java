package com.ifms.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import com.ifms.entities.Marca;
import com.ifms.entities.Modelo;

public class MarcaDTO {

	private Long id;
	
	@NotBlank(message = "O campo é obrigatório")
	private String descricao;
	
	@NotBlank(message = "O campo é obrigatório")
	private List<Modelo> modelos;

	public MarcaDTO(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public MarcaDTO(Marca entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.modelos = entity.getModelos();
	}

	public MarcaDTO() {
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

	public List<Modelo> getModelos() {
		return modelos;
	}

	public static List<MarcaDTO> converter(List<Marca> list) {
		return list.stream().map(MarcaDTO::new).collect(Collectors.toList());
	}
	
}