package br.edu.ifms.gravadora.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.gravadora.dto.GrupoDto;
import br.edu.ifms.gravadora.model.Grupo;
import br.edu.ifms.gravadora.service.GrupoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value ="/grupo")
public class GrupoResource {
	@Autowired
	private GrupoService grupo;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Grupo> find(@PathVariable Integer id) {		
		Grupo obj = grupo.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody GrupoDto objDto) {
		Grupo obj = grupo.fromDto(objDto);
		obj = grupo.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody GrupoDto objDto, @PathVariable Integer id) {
		Grupo obj = grupo.fromDto(objDto);
		obj.setId(id);
		obj = grupo.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Grupo obj,@PathVariable Integer id){
		grupo.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<GrupoDto>> findAll() {		
		List<Grupo> list = grupo.buscarTodos();
		List<GrupoDto> listDto = list.stream().map(obj -> new GrupoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}	

}
