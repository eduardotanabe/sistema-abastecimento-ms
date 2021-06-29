package com.ifms.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import com.ifms.entities.Autoposto;
import com.ifms.entities.Cidade;

public class AutopostoDTO {

	private Long id;
	
	@Size(min = 5, max = 120, message = "O tamanho mínimo é de 5 e no máximo é de 120 caracteres")
	@NotBlank(message = "O campo é obrigatório")
	private String nomeFantasia;
	
	@Size(min = 5, max = 120, message = "O tamanho mínimo é de 5 e no máximo é de 120 caracteres")
	@NotBlank(message = "O campo é obrigatório")
	private String telefone;
	
	@Email
	private String email;
	
	@CNPJ(message = "O CNPJ inválido")
	private String cnpj;

	@NotBlank(message = "O campo é obrigatório")
	private String endereco;

	private Cidade cidade;

	public AutopostoDTO(Long id, String nomeFantasia, String telefone, String email, String cnpj, String endereco,
			Cidade cidade) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.telefone = telefone;
		this.email = email;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.cidade = cidade;
	}
	
	public AutopostoDTO(Autoposto entity) {
		this.id = entity.getId();
		this.nomeFantasia = entity.getNomeFantasia();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
		this.cnpj = entity.getCnpj();
		this.endereco = entity.getEndereco();
		this.cidade = entity.getCidade();
	}

	public AutopostoDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public static List<AutopostoDTO> converter(List<Autoposto> autoposto) {
		return autoposto.stream().map(AutopostoDTO::new).collect(Collectors.toList());
	}
	
}
