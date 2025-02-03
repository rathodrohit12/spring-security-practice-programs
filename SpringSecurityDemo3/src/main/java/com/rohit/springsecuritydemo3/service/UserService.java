package com.rohit.springsecuritydemo3.service;

import com.rohit.springsecuritydemo3.dto.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    public User registerUser(User user);
}
