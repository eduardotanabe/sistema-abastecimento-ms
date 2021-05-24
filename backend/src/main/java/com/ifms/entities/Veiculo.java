package com.ifms.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	private Combustivel tipoCombustivel;
	
	@OneToMany(mappedBy = "veiculo")
	private List<Abastecimento> abastecimentos;
	
	@ManyToMany
	@JoinTable(name = "veiculo_lotacao",
				joinColumns = @JoinColumn(name = "veiculo_id"),
				inverseJoinColumns = @JoinColumn(name = "lotacao_id"))
	Set<Lotacao> lotacoes = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "id_modelo_fk")
	private Modelo modelo;

	@ManyToOne
	@JoinColumn(name = "id_tipo_fk")
	private Tipo tipo;

	public Veiculo(Long id, Integer ano, String placa, String renavam, String patrimonio, String chassi, String versao,
			String capacidadeTanque, Combustivel tipoCombustivel, Modelo modelo, Tipo tipo) {
		this.id = id;
		this.ano = ano;
		this.placa = placa;
		this.renavam = renavam;
		this.patrimonio = patrimonio;
		this.chassi = chassi;
		this.versao = versao;
		this.capacidadeTanque = capacidadeTanque;
		this.tipoCombustivel = tipoCombustivel;
		this.modelo = modelo;
		this.tipo = tipo;
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

	public List<Abastecimento> getAbastecimentos() {
		return abastecimentos;
	}

	public Set<Lotacao> getLotacoes() {
		return lotacoes;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
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
		result = prime * result + ((abastecimentos == null) ? 0 : abastecimentos.hashCode());
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((capacidadeTanque == null) ? 0 : capacidadeTanque.hashCode());
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lotacoes == null) ? 0 : lotacoes.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((patrimonio == null) ? 0 : patrimonio.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((renavam == null) ? 0 : renavam.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((tipoCombustivel == null) ? 0 : tipoCombustivel.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
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
		if (abastecimentos == null) {
			if (other.abastecimentos != null)
				return false;
		} else if (!abastecimentos.equals(other.abastecimentos))
			return false;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (capacidadeTanque == null) {
			if (other.capacidadeTanque != null)
				return false;
		} else if (!capacidadeTanque.equals(other.capacidadeTanque))
			return false;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lotacoes == null) {
			if (other.lotacoes != null)
				return false;
		} else if (!lotacoes.equals(other.lotacoes))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (patrimonio == null) {
			if (other.patrimonio != null)
				return false;
		} else if (!patrimonio.equals(other.patrimonio))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (renavam == null) {
			if (other.renavam != null)
				return false;
		} else if (!renavam.equals(other.renavam))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (tipoCombustivel != other.tipoCombustivel)
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}

	
	
	
}
