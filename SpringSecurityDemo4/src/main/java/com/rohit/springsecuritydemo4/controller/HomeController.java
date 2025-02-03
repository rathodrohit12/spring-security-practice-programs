package com.rohit.springsecuritydemo4.controller;

import com.rohit.springsecuritydemo4.entity.UserEntity;
import com.rohit.springsecuritydemo4.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showHomepage() {
        return "index";
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";
    }


    @GetMapping("/login-page")
    public String showLoginForm() {
        return "login-page";
    }


    @PostMapping("/login")
    public String loginUser(@ModelAttribute UserEntity entity, Model model, HttpSession session) {
        UserEntity user = userService.loginUser(entity);

        if (user == null) {
            model.addAttribute("msg", "Invalid username or password");
            model.addAttribute("msgType", "alert-danger");
            return "login-page";
        } else{
            return "success-page";
        }
    }

    @GetMapping ("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("msg", "You have been logged out.");
        model.addAttribute("msgType", "alert-success");
        return "login-page";
    }


}
