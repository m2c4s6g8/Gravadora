package br.edu.ifms.gravadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.gravadora.dto.GrupoDto;
import br.edu.ifms.gravadora.model.Grupo;
import br.edu.ifms.gravadora.repository.GrupoRepository;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository repositoryGrupo;

	public List<Grupo> buscarTodos(){
	return repositoryGrupo.findAll();
	}

	public Grupo buscarId(Integer id) {
	Optional <Grupo> grupo = repositoryGrupo.findById(id);
	return grupo.orElseThrow();
	}

	public Grupo inserir(Grupo grupo) {
	grupo.setId(null);
	return repositoryGrupo.save(grupo);
	}

	public void remover(Integer id) {
	buscarId(id);
	repositoryGrupo.deleteById(id);
	}
	
	public Grupo atualizar(Grupo grupo) {
		Grupo grupoN = buscarId(grupo.getId());
		grupoN.setNome(grupo.getNome());
		grupoN.setQtdIntegrante(grupo.getQtdIntegrante());
		return repositoryGrupo.save(grupoN );
	}
	
	public Grupo fromDto(GrupoDto grupoDto) {
		return new Grupo(grupoDto.getId(),grupoDto.getNome(),grupoDto.getQtdIntegrante());
	}
}
