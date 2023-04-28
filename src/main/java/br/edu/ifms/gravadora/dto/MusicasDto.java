package br.edu.ifms.gravadora.dto;

import br.edu.ifms.gravadora.model.Musicas;

public class MusicasDto {
	private Integer id;
	private String nome;
	private String cantor;
	private String compositor;
	private int anoLancamento;
	
	public MusicasDto() {
		// TODO Auto-generated constructor stub
	}

	public MusicasDto(Musicas musicas) {
		this.id = musicas.getId();
		this.nome = musicas.getNome();
		this.cantor = musicas.getCantor();
		this.compositor = musicas.getCompositor();
		this.anoLancamento = musicas.getAnoLancamento();
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

	public String getCantor() {
		return cantor;
	}

	public void setCantor(String cantor) {
		this.cantor = cantor;
	}

	public String getCompositor() {
		return compositor;
	}

	public void setCompositor(String compositor) {
		this.compositor = compositor;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	

}
