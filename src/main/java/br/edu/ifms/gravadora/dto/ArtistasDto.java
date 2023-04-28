package br.edu.ifms.gravadora.dto;

import br.edu.ifms.gravadora.model.Artistas;

public class ArtistasDto {
	private Integer id;
	private String nome;
	private int idade;
	private String dataNascimento;
	
	public ArtistasDto() {
		// TODO Auto-generated constructor stub
	}

	public ArtistasDto(Artistas artistas) {
		this.id = artistas.getId();
		this.nome = artistas.getNome();
		this.idade = artistas.getIdade();
		this.dataNascimento = artistas.getDataNascimento();
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

}
