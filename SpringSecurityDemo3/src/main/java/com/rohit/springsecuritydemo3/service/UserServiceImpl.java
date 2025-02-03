package com.rohit.springsecuritydemo3.service;

import com.rohit.springsecuritydemo3.dto.User;
import com.rohit.springsecuritydemo3.entity.UserEntity;
import com.rohit.springsecuritydemo3.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }


    @Override
    public User registerUser(User user) {
        UserEntity entity = modelMapper.map(user, UserEntity.class);
        entity.setPassword(passwordEncoder.encode(user.getPassword()));
        return modelMapper.map(userRepo.save(entity), User.class);
    }
}
