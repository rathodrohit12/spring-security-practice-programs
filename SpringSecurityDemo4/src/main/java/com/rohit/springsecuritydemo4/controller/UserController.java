package com.rohit.springsecuritydemo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/about")
    public String showAboutPage() {
        return "about-user";
    }


    @GetMapping("/profile")
    public String showProfilePage() {
        return "user-profile-page";
    }



}
