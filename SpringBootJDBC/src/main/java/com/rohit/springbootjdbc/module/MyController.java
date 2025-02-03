package com.rohit.springbootjdbc.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class MyController {

    @Autowired
    private MyService myService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerEmployee(@RequestBody Employee employee) {
        Employee employee1 = myService.registerService(employee);
        if (employee1 != null) {
            return ResponseEntity.status(201).body("Employee registered successfully");
        }
        return ResponseEntity.status(500).body("Error during registration");

    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginEmployee(@RequestBody Employee employee) {
        Employee employee1 = myService.loginService(employee);
        if (employee1 != null) {
            return ResponseEntity.ok("employee login successfully");
        }
        return ResponseEntity.status(401).body("Invalid login credentials");

    }

}
