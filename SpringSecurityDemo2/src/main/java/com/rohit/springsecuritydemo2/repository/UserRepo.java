package com.rohit.springsecuritydemo2.repository;

import com.rohit.springsecuritydemo2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	public UserEntity  findByEmail(String email);
	
	
}
