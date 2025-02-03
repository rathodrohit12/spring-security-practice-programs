package com.rohit.springsecuritydemo.usermodule;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    UserServiceImpl(UserRepository repository, ModelMapper modelMapper, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = passwordEncoder;
    }

    @Override
    public UserModel registerUser(UserModel userModel) {
        System.out.println(userModel);
        userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        System.out.println(userModel);
        UserEntity userEntity = repository.save(modelMapper.map(userModel, UserEntity.class));
        return modelMapper.map(userEntity, UserModel.class);
    }

    @Override
    public UserModel updateUser(UserModel userModel) {

        return null;
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return null;
    }

}
