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
import jakarta.persistence.OneToMany;

@Entity
public class Grupo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private int qtdIntegrante;
	@JsonIgnore
	@OneToMany(mappedBy = "grupo")
	private List<Artistas> artistas = new ArrayList<Artistas>();
	
	public List<Artistas> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artistas> artistas) {
		this.artistas = artistas;
	}

	public Grupo() {
		// TODO Auto-generated constructor stub
	}

	public Grupo(Integer id, String nome, int qtdIntegrante) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtdIntegrante = qtdIntegrante;
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

	@Override
	public int hashCode() {
		return Objects.hash(nome, qtdIntegrante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(nome, other.nome) && qtdIntegrante == other.qtdIntegrante;
	}
}
