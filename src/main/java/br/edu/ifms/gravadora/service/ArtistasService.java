package br.edu.ifms.gravadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.gravadora.dto.ArtistasDto;
import br.edu.ifms.gravadora.model.Artistas;
import br.edu.ifms.gravadora.repository.ArtistasRepository;

@Service
public class ArtistasService {
	@Autowired
	private ArtistasRepository repositoryArtistas;

	public List<Artistas> buscarTodos(){
	return repositoryArtistas.findAll();
	}

	public Artistas buscarId(Integer id) {
	Optional <Artistas> artistas = repositoryArtistas.findById(id);
	return artistas.orElseThrow();
	}

	public Artistas inserir(Artistas artistas) {
	artistas.setId(null);
	return repositoryArtistas.save(artistas);
	}

	public void remover(Integer id) {
	buscarId(id);
	repositoryArtistas.deleteById(id);
	}
	
	public Artistas atualizar(Artistas artistas) {
		Artistas artistasN = buscarId(artistas.getId());
		artistasN.setNome(artistas.getNome());
		artistasN .setIdade(artistas.getIdade());
		artistasN .setDataNascimento(artistas.getDataNascimento());
		return repositoryArtistas.save(artistasN );
	}
	
	public Artistas fromDto(ArtistasDto artistasDto) {
		return new Artistas(artistasDto.getId(),artistasDto.getNome(),artistasDto.getIdade(),artistasDto.getDataNascimento(),null,null);
	}
}
