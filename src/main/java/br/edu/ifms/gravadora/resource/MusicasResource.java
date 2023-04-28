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


import br.edu.ifms.gravadora.dto.MusicasDto;
import br.edu.ifms.gravadora.model.Musicas;
import br.edu.ifms.gravadora.service.MusicasService;
import jakarta.validation.Valid;



@RestController
@RequestMapping(value ="/musicas")
public class MusicasResource {
	
	@Autowired
	private MusicasService musicas;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Musicas> find(@PathVariable Integer id) {		
		Musicas obj = musicas.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MusicasDto objDto) {
		Musicas obj = musicas.fromDto(objDto);
		obj = musicas.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody MusicasDto objDto, @PathVariable Integer id) {
		Musicas obj = musicas.fromDto(objDto);
		obj.setId(id);
		obj = musicas.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Musicas obj,@PathVariable Integer id){
		musicas.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MusicasDto>> findAll() {		
		List<Musicas> list = musicas.buscarTodos();
		List<MusicasDto> listDto = list.stream().map(obj -> new MusicasDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}	

}
