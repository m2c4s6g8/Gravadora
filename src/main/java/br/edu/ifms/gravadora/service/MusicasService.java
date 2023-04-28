package br.edu.ifms.gravadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.gravadora.dto.MusicasDto;
import br.edu.ifms.gravadora.model.Musicas;
import br.edu.ifms.gravadora.repository.MusicasRepository;

@Service
public class MusicasService {
	@Autowired
	private MusicasRepository repositoryMusicas;

	public List<Musicas> buscarTodos(){
	return repositoryMusicas.findAll();
	}

	public Musicas buscarId(Integer id) {
	Optional <Musicas> musicas = repositoryMusicas.findById(id);
	return musicas.orElseThrow(); 
	}

	public Musicas inserir(Musicas musicas) {
	musicas.setId(null);
	return repositoryMusicas.save(musicas);
	}

	public void remover(Integer id) {
	buscarId(id);
	repositoryMusicas.deleteById(id);
	}
	
	public Musicas atualizar(Musicas musicas) {
		Musicas musicasN = buscarId(musicas.getId());
		musicasN.setNome(musicas.getNome());
		musicasN .setCantor(musicas.getCantor());
		musicasN .setCompositor(musicas.getCompositor());
		musicasN .setAnoLancamento(musicas.getAnoLancamento());
		return repositoryMusicas.save(musicasN );
	}
	
	public Musicas fromDto(MusicasDto musicasDto) {
		return new Musicas(musicasDto.getId(),musicasDto.getNome(),musicasDto.getCantor(),musicasDto.getCompositor(),musicasDto.getAnoLancamento());
	}
}
