package com.rohit.springsecuritydemo2.service;

import com.rohit.springsecuritydemo2.entity.UserEntity;
import com.rohit.springsecuritydemo2.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	private final UserRepo repo;
	private final PasswordEncoder passwordEncoder;
	public UserService(UserRepo repo, PasswordEncoder passwordEncoder) {
		this.repo=repo;
	    this.passwordEncoder=passwordEncoder;
	}
	
	public UserEntity registerUser(UserEntity  entity) {
		entity.setPass(passwordEncoder.encode(entity.getPass()));
		return repo.save(entity); 
	}

}
