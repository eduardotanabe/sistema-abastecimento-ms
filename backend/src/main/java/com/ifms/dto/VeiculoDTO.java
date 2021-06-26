package com.ifms.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.ifms.entities.Tipo;
import com.ifms.entities.Veiculo;
import com.ifms.entities.enums.Combustivel;

public class VeiculoDTO {

	private Long id;
	private Integer ano;
	private String placa;
	private String renavam;
	private String patrimonio;
	private String chassi;
	private String versao;
	private String capacidadeTanque;
	private Combustivel tipoCombustivel;
	private Tipo tipo;

	public VeiculoDTO(Long id, Integer ano, String placa, String renavam, String patrimonio, String chassi, String versao,
			String capacidadeTanque, Combustivel tipoCombustivel, Tipo tipo) {
		this.id = id;
		this.ano = ano;
		this.placa = placa;
		this.renavam = renavam;
		this.patrimonio = patrimonio;
		this.chassi = chassi;
		this.versao = versao;
		this.capacidadeTanque = capacidadeTanque;
		this.tipoCombustivel = tipoCombustivel;
		this.tipo = tipo;
	}

	public VeiculoDTO(Veiculo entity) {
		this.id = entity.getId();
		this.ano = entity.getAno();
		this.placa = entity.getPlaca();
		this.renavam = entity.getRenavam();
		this.patrimonio = entity.getPatrimonio();
		this.chassi = entity.getChassi();
		this.versao = entity.getVersao();
		this.capacidadeTanque = entity.getCapacidadeTanque();
		this.tipoCombustivel = entity.getTipoCombustivel();
		this.tipo = entity.getTipo();
	}

	public VeiculoDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(String capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public Combustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(Combustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public static List<VeiculoDTO> converter(List<Veiculo> list) {
		return list.stream().map(VeiculoDTO::new).collect(Collectors.toList());
	}

	
	
}
