package com.ifms.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import com.ifms.entities.Cidade;
import com.ifms.entities.Estado;

public class CidadeDTO {

	private Long id;
	
	@NotBlank(message = "O campo é obrigatório")
	private String nome;
	
	@NotBlank(message = "O campo é obrigatório")
	private Estado estado;

	public CidadeDTO(Long id, String nome, Estado estado) {
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	public CidadeDTO(Cidade entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.estado = entity.getEstado();
	}

	public CidadeDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public static List<CidadeDTO> converter(List<Cidade> cidade) {
		return cidade.stream().map(CidadeDTO::new).collect(Collectors.toList());
	}

	
	
	
	
}
