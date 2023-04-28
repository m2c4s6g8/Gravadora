package br.edu.ifms.gravadora.dto;

import br.edu.ifms.gravadora.model.Gravadora;

public class GravadoraDto {
	private Integer id;
	private String nome;
	private String cnpj;
	
	public GravadoraDto() {
		// TODO Auto-generated constructor stub
	}

	public GravadoraDto(Gravadora gravadora) {
		this.id = gravadora.getId();
		this.nome = gravadora.getNome();
		this.cnpj = gravadora.getCnpj();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
