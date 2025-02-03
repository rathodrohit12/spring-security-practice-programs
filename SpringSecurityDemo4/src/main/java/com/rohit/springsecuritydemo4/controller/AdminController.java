package com.rohit.springsecuritydemo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/about")
    public String showAboutPage() {
        return "about-admin";
    }


    @GetMapping("/profile")
    public String showProfilePage() {
        return "admin-profile-page";
    }
}
