package com.bh.controller;

import java.util.Map;

import com.bh.entity.EmpEntity;
import com.bh.model.EmpLoginModel;
import com.bh.model.EmpOTPModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.bh.model.EmpModel;
import com.bh.service.EmpService;

import com.bh.utils.ResponseHandler;


import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/emp")
public class EmpController {

	EmpService empService;

	public EmpController(EmpService empService) {
		super();
		this.empService = empService;
	}

	@PostMapping("/register")
	public ResponseEntity<Object> empRegister(@Valid @RequestBody EmpModel empModel) {
		EmpModel empModel2 = empService.empRegisterService(empModel);

		if (empModel2 == null) {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "employee already exist", empModel);

		}

		else {
			return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "Customer Register Successfuly",
					empModel2);

		}
	}


	@PutMapping("/verifyOtp")
	public ResponseEntity<Object> verifyOTP(@Valid @RequestBody EmpOTPModel empModel) {
		EmpEntity empModel1 = empService.getuserByEmailAndOtp(empModel);
		if(empModel1 != null) {
			return ResponseHandler.generateResponse(HttpStatus.OK, true, "OTP verified", empModel);
		}else{
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "OTP does not match", empModel);
		}

	}

	@PostMapping("/login")
	public ResponseEntity empLogin(@Valid @RequestBody EmpLoginModel empModel) {
		EmpLoginModel empLoginModel = empService.empLoginService(empModel);
		if(empLoginModel != null) {
			return ResponseHandler.generateResponse(HttpStatus.OK, true, "Login Successful", empModel);
		}else{
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Invalid credentials", empModel);
		}
	}





}
