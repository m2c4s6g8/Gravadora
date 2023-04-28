package br.edu.ifms.gravadora.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Musicas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cantor;
	private String compositor;
	private int anoLancamento;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "musicas")
	private List<Artistas> artistas= new ArrayList<Artistas>();
	
	public Musicas() {
		// TODO Auto-generated constructor stub
	}

	public Musicas(Integer id, String nome, String cantor, String compositor, int anoLancamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cantor = cantor;
		this.compositor = compositor;
		this.anoLancamento = anoLancamento;
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

	@Override
	public int hashCode() {
		return Objects.hash(anoLancamento, cantor, compositor, nome);
	}

	public List<Artistas> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artistas> artistas) {
		this.artistas = artistas;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musicas other = (Musicas) obj;
		return anoLancamento == other.anoLancamento && Objects.equals(cantor, other.cantor)
				&& Objects.equals(compositor, other.compositor) && Objects.equals(nome, other.nome);
	}
}
