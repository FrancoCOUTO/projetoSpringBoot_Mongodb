package com.francocouto.projetoMongo.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.francocouto.projetoMongo.domain.User;

@Repository
public interface UserRepositorio extends MongoRepository<User, String> {

}
