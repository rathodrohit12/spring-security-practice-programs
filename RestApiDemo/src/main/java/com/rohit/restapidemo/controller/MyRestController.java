package com.rohit.restapidemo.controller;


import com.rohit.restapidemo.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {


    @GetMapping("/hi")
    public Employee sayHello(){
        return new Employee(100, "ram");
    }



}
