package com.francocouto.projetoMongo.recursos;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francocouto.projetoMongo.domain.Post;
import com.francocouto.projetoMongo.servico.PostServico;

@RestController
@RequestMapping(value = "/post")
public class PostRecurso {
	
	@Autowired
	PostServico servico;

	@GetMapping
	public ResponseEntity<List<Post>> FindAll(){
		List<Post> posts = servico.findAll();
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = servico.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value="/titlesearch")
 	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URLUtil.decodeParam(text);
		List<Post> list = servico.findByTitle(text);
		return ResponseEntity.ok().body(list);
	
	
} 
}