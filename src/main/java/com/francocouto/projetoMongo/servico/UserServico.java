package com.francocouto.projetoMongo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francocouto.projetoMongo.domain.User;
import com.francocouto.projetoMongo.dto.UserDTO;
import com.francocouto.projetoMongo.repositorios.UserRepositorio;
import com.francocouto.projetoMongo.servico.execoes.ObjectNotFoundException;

@Service
public class UserServico {

	@Autowired
	private UserRepositorio userRepositorio;

	public List<User> findAll() {
		return userRepositorio.findAll();

	}
	
	public User findById(String id) {
		Optional<User> user = userRepositorio.findById(id);
		return user.orElseThrow(()->  new ObjectNotFoundException("Usuario nao encontrado"));
		
	}
	
	public User insert (User obj) {
		return userRepositorio.insert(obj);
		
	}
	
	public User fromDTO(UserDTO obj) {
		  return new User(obj.getId(), obj.getNome(), obj.getEmail());
	}

}
