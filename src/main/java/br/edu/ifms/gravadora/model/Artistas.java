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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Artistas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private int idade;
	private String dataNascimento;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="gravadora_id")
	private Gravadora gravadora;
	
	
	@ManyToMany
	@JoinTable(
			name = "Artistas_Musicas",
			joinColumns = @JoinColumn(name = "artistas_id"),
			inverseJoinColumns = @JoinColumn(name = "musicas_id"))
	private List<Musicas> musicas= new ArrayList<Musicas>();
	
	
	@ManyToOne
	@JoinColumn(name="grupo_id")
	private Grupo grupo;
	
	public Artistas() {
		// TODO Auto-generated constructor stub
	}

	public Gravadora getGravadora() {
		return gravadora;
	}

	public void setGravadora(Gravadora gravadora) {
		this.gravadora = gravadora;
	}

	public List<Musicas> getMusicas() {
		return musicas;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public void setMusicas(List<Musicas> musicas) {
		this.musicas = musicas;
	}

	public Artistas(Integer id, String nome, int idade, String dataNascimento, Gravadora gravadora, Grupo grupo) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.dataNascimento = dataNascimento;
		this.gravadora = gravadora;
		this.grupo = grupo;
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

	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento, idade, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artistas other = (Artistas) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && idade == other.idade
				&& Objects.equals(nome, other.nome);
	}
}
