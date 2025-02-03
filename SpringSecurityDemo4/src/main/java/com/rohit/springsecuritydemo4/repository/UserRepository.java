package com.rohit.springsecuritydemo4.repository;

import com.rohit.springsecuritydemo4.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
	UserEntity findByMobile(String mobile);

}
