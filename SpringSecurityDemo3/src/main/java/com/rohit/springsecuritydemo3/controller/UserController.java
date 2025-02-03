package com.rohit.springsecuritydemo3.controller;

import com.rohit.springsecuritydemo3.dto.User;
import com.rohit.springsecuritydemo3.entity.UserEntity;
import com.rohit.springsecuritydemo3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(){
        return "Hello World";
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user){
        User user1 = userService.registerUser(user);
        if(user1 != null){
            return ResponseEntity.ok(HttpStatus.CREATED);
        }else {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

    }


    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user){
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
