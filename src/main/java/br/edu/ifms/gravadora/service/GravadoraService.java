package br.edu.ifms.gravadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.gravadora.dto.GravadoraDto;
import br.edu.ifms.gravadora.model.Gravadora;
import br.edu.ifms.gravadora.repository.GravadoraRepository;

@Service
public class GravadoraService {
	
	@Autowired
	private GravadoraRepository repositoryGravadora;
	
	public List<Gravadora> buscarTodos(){
		return repositoryGravadora.findAll();
	}
	
	public Gravadora buscarId(Integer id) {
		Optional <Gravadora> gravadora = repositoryGravadora.findById(id);
		return gravadora.orElseThrow() ;
		}

		public Gravadora inserir(Gravadora gravadora) {
		gravadora.setId(null);
		return repositoryGravadora.save(gravadora);
		}

		public void remover(Integer id) {
		buscarId(id);
		repositoryGravadora.deleteById(id);
		}
		
		public Gravadora atualizar(Gravadora gravadora) {
			Gravadora gravadoraN = buscarId(gravadora.getId());
			gravadoraN.setNome(gravadora.getNome());
			gravadoraN.setCnpj(gravadora.getCnpj());
			
			return repositoryGravadora.save(gravadoraN);
		}
		
		public Gravadora fromDto(GravadoraDto gravadoraDto) {
			return new Gravadora(gravadoraDto.getId(),gravadoraDto.getNome(),gravadoraDto.getCnpj());
		}

}
