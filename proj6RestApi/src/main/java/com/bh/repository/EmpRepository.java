package com.bh.repository;

import java.util.Optional;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bh.entity.EmpEntity;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, Integer> {

	public Optional<EmpEntity> findByEmailOrMobile(String email,String mobile);

    EmpEntity findByEmailAndOtp( String email, String otp);
    EmpEntity findByEmailAndPassword( String email, String password);
}
