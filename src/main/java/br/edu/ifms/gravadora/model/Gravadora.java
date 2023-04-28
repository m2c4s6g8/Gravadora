package br.edu.ifms.gravadora.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Gravadora implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cnpj;
	
	
	@OneToMany(mappedBy = "gravadora")
	private List<Artistas> artistas = new ArrayList<Artistas>();
	
	public Gravadora() {
		// TODO Auto-generated constructor stub
	}

	public Gravadora(Integer id, String nome, String cnpj) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	

	public List<Artistas> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artistas> artistas) {
		this.artistas = artistas;
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

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gravadora other = (Gravadora) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(nome, other.nome);
	}
}
