package com.francocouto.projetoMongo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.francocouto.projetoMongo.domain.Post;
import com.francocouto.projetoMongo.recursos.execoes.DataError;
import com.francocouto.projetoMongo.repositorios.PostRepositorio;

@Service
public class PostServico {
	
	@Autowired
	PostRepositorio repositorio;
	
	public  List<Post> findAll() {
		return  repositorio.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> post = repositorio.findById(id);
		return post.orElseThrow(() -> new DataError("Post  nao encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return repositorio.findByTituloContainingIgnoreCase(text);
	}
}

	
