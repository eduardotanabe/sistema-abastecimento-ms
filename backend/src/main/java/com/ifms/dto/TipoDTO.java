package com.ifms.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.ifms.entities.Tipo;

public class TipoDTO {

	private Long id;
	private String descricao;

	public TipoDTO(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public TipoDTO(Tipo entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
	}

	public TipoDTO() {
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

	public static List<TipoDTO> converter(List<Tipo> list) {
		return list.stream().map(TipoDTO::new).collect(Collectors.toList());
	}
	
	
	
	
}
