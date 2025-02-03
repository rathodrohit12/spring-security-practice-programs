package com.rohit.springsecuritydemo4.service;

import com.rohit.springsecuritydemo4.entity.UserEntity;


public interface UserService {
	
	public UserEntity loginUser(UserEntity userEntity);

}