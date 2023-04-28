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

import br.edu.ifms.gravadora.dto.GravadoraDto;
import br.edu.ifms.gravadora.model.Gravadora;
import br.edu.ifms.gravadora.service.GravadoraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value ="/gravadora")
public class GravadoraResource {

	@Autowired
	private GravadoraService gravadora;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Gravadora> find(@PathVariable Integer id) {		
		Gravadora obj = gravadora.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody GravadoraDto objDto) {
		Gravadora obj = gravadora.fromDto(objDto);
		obj = gravadora.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody GravadoraDto objDto, @PathVariable Integer id) {
		Gravadora obj = gravadora.fromDto(objDto);
		obj.setId(id);
		obj = gravadora.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Gravadora obj,@PathVariable Integer id){
		gravadora.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<GravadoraDto>> findAll() {		
		List<Gravadora> list = gravadora.buscarTodos();
		List<GravadoraDto> listDto = list.stream().map(obj -> new GravadoraDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}	
}
