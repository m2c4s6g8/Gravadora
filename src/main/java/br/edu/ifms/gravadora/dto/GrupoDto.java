package br.edu.ifms.gravadora.dto;

import br.edu.ifms.gravadora.model.Grupo;

public class GrupoDto {
	private Integer id;
	private String nome;
	private int qtdIntegrante;
	
	public GrupoDto() {
		// TODO Auto-generated constructor stub
	}

	public GrupoDto(Grupo grupo) {
		this.id = grupo.getId();
		this.nome = grupo.getNome();
		this.qtdIntegrante = grupo.getQtdIntegrante();
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

	public int getQtdIntegrante() {
		return qtdIntegrante;
	}

	public void setQtdIntegrante(int qtdIntegrante) {
		this.qtdIntegrante = qtdIntegrante;
	}
	
	
}
