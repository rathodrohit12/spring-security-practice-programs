package com.rohit.springsecuritydemo.usermodule;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserModel user) {
        System.out.println("**************************************************");
        UserModel userModel = userService.registerUser(user);
        System.out.println(userModel);
        if (userModel == null) {
            return ResponseEntity.badRequest().body("User could not be registered");
        }
        else
            return ResponseEntity.ok().body(userModel);
    }

}
