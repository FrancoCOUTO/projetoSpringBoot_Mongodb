package com.francocouto.projetoMongo.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francocouto.projetoMongo.domain.User;
import com.francocouto.projetoMongo.repositorios.UserRepositorio;

@Service
public class UserServico {
	
	@Autowired
	private UserRepositorio userRepositorio;
	
	public List<User> findAll(){
		return userRepositorio.findAll();
		
		
	}

}
