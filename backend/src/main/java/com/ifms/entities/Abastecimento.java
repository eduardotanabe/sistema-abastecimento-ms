package com.ifms.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ifms.entities.enums.Combustivel;

@Entity
public class Abastecimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cpf_motorista")
	private String cpfMotorista;
	
	@Column(name = "data_do_abastecimento", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataDoAbastecimento;
	
	@Column
	private String quilometragem;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	private Combustivel combustivel;
	
	@Column(name = "quantidade_em_litros")
	private Integer quantidadeEmLitros;
	
	@Column(name = "valor_por_litro")
	private Double valorPorLitro;
	
	@ManyToOne
	@JoinColumn(name = "id_autoposto_fk")
	private Autoposto autoPosto;
	
	@ManyToOne
	@JoinColumn(name = "id_veiculo_fk")
	private Veiculo veiculo;
	
	public Abastecimento() {
	}

	public Abastecimento(Long id, String cpfMotorista, Instant dataDoAbastecimento, String quilometragem,
			Combustivel combustivel, Integer quantidadeEmLitros, Double valorPorLitro, Autoposto autoPosto,
			Veiculo veiculo) {
		this.id = id;
		this.cpfMotorista = cpfMotorista;
		this.dataDoAbastecimento = dataDoAbastecimento;
		this.quilometragem = quilometragem;
		this.combustivel = combustivel;
		this.quantidadeEmLitros = quantidadeEmLitros;
		this.valorPorLitro = valorPorLitro;
		this.autoPosto = autoPosto;
		this.veiculo = veiculo;
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

	public Instant getDataDoAbastecimento() {
		return dataDoAbastecimento;
	}

	public void setDataDoAbastecimento(Instant dataDoAbastecimento) {
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
	
	public Autoposto getAutoPosto() {
		return autoPosto;
	}

	public void setAutoPosto(Autoposto autoPosto) {
		this.autoPosto = autoPosto;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autoPosto == null) ? 0 : autoPosto.hashCode());
		result = prime * result + ((combustivel == null) ? 0 : combustivel.hashCode());
		result = prime * result + ((cpfMotorista == null) ? 0 : cpfMotorista.hashCode());
		result = prime * result + ((dataDoAbastecimento == null) ? 0 : dataDoAbastecimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quantidadeEmLitros == null) ? 0 : quantidadeEmLitros.hashCode());
		result = prime * result + ((quilometragem == null) ? 0 : quilometragem.hashCode());
		result = prime * result + ((valorPorLitro == null) ? 0 : valorPorLitro.hashCode());
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
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
		Abastecimento other = (Abastecimento) obj;
		if (autoPosto == null) {
			if (other.autoPosto != null)
				return false;
		} else if (!autoPosto.equals(other.autoPosto))
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
		if (valorPorLitro == null) {
			if (other.valorPorLitro != null)
				return false;
		} else if (!valorPorLitro.equals(other.valorPorLitro))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}

}
