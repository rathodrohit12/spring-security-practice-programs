package com.rohit.springsecuritydemo2.service;

import com.rohit.springsecuritydemo2.entity.UserEntity;
import com.rohit.springsecuritydemo2.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class MyUserDetailService implements UserDetailsService {

	private final UserRepo userRepo;

	public MyUserDetailService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity entity = userRepo.findByEmail(username);
		System.out.println("Entity:"+entity);
		
		return new MyUserService(entity);
	}

}
