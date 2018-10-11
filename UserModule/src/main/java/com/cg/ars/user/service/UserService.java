package com.cg.ars.user.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.ars.user.dto.User;

public interface UserService extends MongoRepository<User, String> {

}
