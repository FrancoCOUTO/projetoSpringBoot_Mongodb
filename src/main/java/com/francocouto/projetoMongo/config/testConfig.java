package com.francocouto.projetoMongo.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.francocouto.projetoMongo.domain.Post;
import com.francocouto.projetoMongo.domain.User;
import com.francocouto.projetoMongo.dto.AutorDTO;
import com.francocouto.projetoMongo.dto.ComentarioDto;
import com.francocouto.projetoMongo.repositorios.PostRepositorio;
import com.francocouto.projetoMongo.repositorios.UserRepositorio;

@Configuration
public class testConfig implements CommandLineRunner {

	@Autowired
	private UserRepositorio userRepositorio;

	@Autowired
	private PostRepositorio postRepositorio;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepositorio.deleteAll();
		postRepositorio.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User ze = new User(null, "Ze antonio", "ze@gmail.com");

		userRepositorio.saveAll(Arrays.asList(maria, alex, bob, ze));

		Post post1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AutorDTO(maria));
		Post post2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));

		ComentarioDto c1 = new ComentarioDto("Boa viagem mano", Instant.now(), new AutorDTO(alex));
		ComentarioDto c2 = new ComentarioDto("Aproveite", Instant.now(), new AutorDTO(bob));
		ComentarioDto c3 = new ComentarioDto("Tenha um otimo dia", Instant.now(), new AutorDTO(alex));
		
		post1.getComentario().add(c1);
		post1.getComentario().add(c2);
		post2.getComentario().add(c3);
		
		postRepositorio.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepositorio.save(maria);
		
		
		
		
		 
		
		

	}

}
