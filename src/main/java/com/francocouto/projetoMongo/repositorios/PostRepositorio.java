package com.francocouto.projetoMongo.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.francocouto.projetoMongo.domain.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String> {
	List<Post> findByTituloContainingIgnoreCase(String text);
}
