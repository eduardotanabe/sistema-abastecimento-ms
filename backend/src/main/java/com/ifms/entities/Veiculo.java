package com.ifms.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ifms.dto.VeiculoDTO;
import com.ifms.entities.enums.Combustivel;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Integer ano;
	
	@Column
	private String placa;
	
	@Column
	private String renavam;

	@Column
	private String patrimonio;

	@Column
	private String chassi;

	@Column
	private String versao;
	
	@Column(name = "capacidade_tanque")
	private String capacidadeTanque;
	
	@Column(name = "tipo_combustivel")
	@Enumerated(EnumType.ORDINAL)
	private Combustivel tipoCombustivel;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_fk")
	private Tipo tipo;

	public Veiculo(Long id, Integer ano, String placa, String renavam, String patrimonio, String chassi, String versao,
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

	public Veiculo(VeiculoDTO entity) {
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

	public Veiculo() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
