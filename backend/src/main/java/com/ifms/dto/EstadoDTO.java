package com.ifms.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import com.ifms.entities.Estado;

public class EstadoDTO {

	private Long id;
	
	@NotBlank(message = "O campo é obrigatório")
	private String uf;

	public EstadoDTO(Long id, String uf) {
		this.id = id;
		this.uf = uf;
	}

	public EstadoDTO(Estado entity) {
		this.id = entity.getId();
		this.uf = entity.getUf();
	}

	public EstadoDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public static List<EstadoDTO> converter(List<Estado> estados) {
		return estados.stream().map(EstadoDTO::new).collect(Collectors.toList());
	}
	
}
