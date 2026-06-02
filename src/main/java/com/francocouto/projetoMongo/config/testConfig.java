package com.francocouto.projetoMongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.francocouto.projetoMongo.domain.User;
import com.francocouto.projetoMongo.repositorios.UserRepositorio;

@Configuration
public class testConfig implements CommandLineRunner {

	@Autowired
	private UserRepositorio userRepositorio;

	@Override
	public void run(String... args) throws Exception {

		userRepositorio.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User ze = new User(null, "Ze antonio", "ze@gmail.com");

		userRepositorio.saveAll(Arrays.asList(maria, alex, bob, ze));

	}

}
