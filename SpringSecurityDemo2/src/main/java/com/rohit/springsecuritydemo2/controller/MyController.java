package com.rohit.springsecuritydemo2.controller;

import com.rohit.springsecuritydemo2.entity.UserEntity;
import com.rohit.springsecuritydemo2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class MyController {
	
	private final UserService userService;
	private final AuthenticationManager authenticationManager;

	MyController(UserService userService, AuthenticationManager authenticationManager) {
		this.userService=userService;
		this.authenticationManager=authenticationManager;
	}

	@GetMapping("/home")
	public String home() {
		return "home page";
	}
      
	@PostMapping( "/register" )
	public ResponseEntity<UserEntity> userRegister(@RequestBody UserEntity entity) {
		userService.registerUser(entity);
		return new ResponseEntity<UserEntity>(HttpStatus.CREATED);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> userLogin(@RequestBody UserEntity entity) {
		 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                entity.getEmail(), entity.getPass()));

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        if (authentication.isAuthenticated()) {
	        	
	        	return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);	
			}else {
				return new ResponseEntity<>("invalid username password!.", HttpStatus.BAD_REQUEST);
			}
	        
		
		
		
		
	}
	


}

