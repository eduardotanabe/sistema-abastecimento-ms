package com.ifms.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.ifms.entities.Abastecimento;
import com.ifms.entities.Autoposto;
import com.ifms.entities.Veiculo;
import com.ifms.entities.enums.Combustivel;

public class AbastecimentoDTO {

	private Long id;
	
	@CPF(message = "O CPF está incorreto")
	private String cpfMotorista;
	
	@NotBlank(message = "O campo é obrigatório")
	@Past
	private Instant dataDoAbastecimento;
	
	@NotBlank(message = "O campo é obrigatório")
	private String quilometragem;
	
	@NotBlank(message = "O campo é obrigatório")
	private Combustivel combustivel;
	
	@NotBlank(message = "O campo é obrigatório")
	private Integer quantidadeEmLitros;
	
	@NotBlank(message = "O campo é obrigatório")
	private Double valorPorLitro;
	
	@NotBlank(message = "O campo é obrigatório")
	private Autoposto autoPosto;
	
	@NotBlank(message = "O campo é obrigatório")
	private Veiculo veiculo;
	
	public AbastecimentoDTO(Abastecimento entity) {
		this.id = entity.getId();
		this.cpfMotorista = entity.getCpfMotorista();
		this.dataDoAbastecimento = entity.getDataDoAbastecimento();
		this.quilometragem = entity.getQuilometragem();
		this.combustivel = entity.getCombustivel();
		this.quantidadeEmLitros = entity.getQuantidadeEmLitros();
		this.valorPorLitro = entity.getValorPorLitro();
		this.autoPosto = entity.getAutoPosto();
		this.veiculo = entity.getVeiculo();
	}

	public AbastecimentoDTO(Long id, String cpfMotorista, Instant dataDoAbastecimento, String quilometragem,
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

	public AbastecimentoDTO() {
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

	public static List<AbastecimentoDTO> converter(List<Abastecimento> abastecimento) {
		return abastecimento.stream().map(AbastecimentoDTO::new).collect(Collectors.toList());
	}



}
