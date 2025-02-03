package com.rohit.springsecuritydemo3.service;

import com.rohit.springsecuritydemo3.dto.User;
import com.rohit.springsecuritydemo3.entity.UserEntity;
import com.rohit.springsecuritydemo3.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public UserDetailsServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = userRepo.findByEmail(username);
        return new UserDetailsImpl(modelMapper.map(entity, User.class));

    }
}
