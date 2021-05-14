package com.ifms.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cpf_motorista")
	private String cpfMotorista;
	
	@Column(name = "data_do_abastecimento")
	private Date dataDoAbastecimento;
	
	@Column
	private String quilometragem;
	
	@Column
	private Combustivel combustivel;
	
	@Column(name = "quantidade_em_litros")
	private Integer quantidadeEmLitros;
	
	@Column(name = "valor_por_litro")
	private Double valorPorLitro;
	
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

	public Veiculo(Long id, String cpfMotorista, Date dataDoAbastecimento, String quilometragem,
			Combustivel combustivel, Integer quantidadeEmLitros, Double valorPorLitro, Modelo modelo, Tipo tipo) {
		this.id = id;
		this.cpfMotorista = cpfMotorista;
		this.dataDoAbastecimento = dataDoAbastecimento;
		this.quilometragem = quilometragem;
		this.combustivel = combustivel;
		this.quantidadeEmLitros = quantidadeEmLitros;
		this.valorPorLitro = valorPorLitro;
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

	public String getCpfMotorista() {
		return cpfMotorista;
	}

	public void setCpfMotorista(String cpfMotorista) {
		this.cpfMotorista = cpfMotorista;
	}

	public Date getDataDoAbastecimento() {
		return dataDoAbastecimento;
	}

	public void setDataDoAbastecimento(Date dataDoAbastecimento) {
		this.dataDoAbastecimento = dataDoAbastecimento;
	}

	public String getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(String quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public Integer getQuantidadeEmLitros() {
		return quantidadeEmLitros;
	}

	public void setQuantidadeEmLitros(Integer quantidadeEmLitros) {
		this.quantidadeEmLitros = quantidadeEmLitros;
	}

	public Double getValorPorLitro() {
		return valorPorLitro;
	}

	public void setValorPorLitro(Double valorPorLitro) {
		this.valorPorLitro = valorPorLitro;
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

	public List<Abastecimento> getAbastecimentos() {
		return abastecimentos;
	}

	public Set<Lotacao> getLotacoes() {
		return lotacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abastecimentos == null) ? 0 : abastecimentos.hashCode());
		result = prime * result + ((combustivel == null) ? 0 : combustivel.hashCode());
		result = prime * result + ((cpfMotorista == null) ? 0 : cpfMotorista.hashCode());
		result = prime * result + ((dataDoAbastecimento == null) ? 0 : dataDoAbastecimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lotacoes == null) ? 0 : lotacoes.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((quantidadeEmLitros == null) ? 0 : quantidadeEmLitros.hashCode());
		result = prime * result + ((quilometragem == null) ? 0 : quilometragem.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((valorPorLitro == null) ? 0 : valorPorLitro.hashCode());
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
		if (combustivel != other.combustivel)
			return false;
		if (cpfMotorista == null) {
			if (other.cpfMotorista != null)
				return false;
		} else if (!cpfMotorista.equals(other.cpfMotorista))
			return false;
		if (dataDoAbastecimento == null) {
			if (other.dataDoAbastecimento != null)
				return false;
		} else if (!dataDoAbastecimento.equals(other.dataDoAbastecimento))
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
		if (quantidadeEmLitros == null) {
			if (other.quantidadeEmLitros != null)
				return false;
		} else if (!quantidadeEmLitros.equals(other.quantidadeEmLitros))
			return false;
		if (quilometragem == null) {
			if (other.quilometragem != null)
				return false;
		} else if (!quilometragem.equals(other.quilometragem))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (valorPorLitro == null) {
			if (other.valorPorLitro != null)
				return false;
		} else if (!valorPorLitro.equals(other.valorPorLitro))
			return false;
		return true;
	}

	

	
	
	
}
