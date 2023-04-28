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

import br.edu.ifms.gravadora.dto.ArtistasDto;
import br.edu.ifms.gravadora.model.Artistas;
import br.edu.ifms.gravadora.service.ArtistasService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value ="/artistas")
public class ArtistasResource {
	@Autowired
	private ArtistasService artistas;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Artistas> find(@PathVariable Integer id) {		
		Artistas obj = artistas.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ArtistasDto objDto) {
		Artistas obj = artistas.fromDto(objDto);
		obj = artistas.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ArtistasDto objDto, @PathVariable Integer id) {
		Artistas obj = artistas.fromDto(objDto);
		obj.setId(id);
		obj = artistas.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Artistas obj,@PathVariable Integer id){
		artistas.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ArtistasDto>> findAll() {		
		List<Artistas> list = artistas.buscarTodos();
		List<ArtistasDto> listDto = list.stream().map(obj -> new ArtistasDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}	
}
