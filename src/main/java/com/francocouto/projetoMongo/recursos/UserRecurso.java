package com.francocouto.projetoMongo.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.francocouto.projetoMongo.domain.User;
import com.francocouto.projetoMongo.dto.UserDTO;
import com.francocouto.projetoMongo.servico.UserServico;

@RestController
@RequestMapping(value = "/users")
public class UserRecurso {

	@Autowired
	private UserServico servico;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> lista = servico.findAll();
		List<UserDTO> dto = lista.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dto);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = servico.findById(id);
		UserDTO dto = new UserDTO(obj);
		return ResponseEntity.ok().body(dto);

	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
		User user = servico.fromDTO(userDTO);
		user = servico.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();

	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO objdto){
		User obj = servico.fromDTO(objdto);
		obj = servico.update(id, obj);
		return ResponseEntity.ok().body(new UserDTO(obj));
		
	}
	

}
