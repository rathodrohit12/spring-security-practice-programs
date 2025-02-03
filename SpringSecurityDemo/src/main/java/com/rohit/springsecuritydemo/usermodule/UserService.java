package com.rohit.springsecuritydemo.usermodule;



public interface UserService {


    public UserModel registerUser(UserModel userModel);
    public UserModel updateUser(UserModel userModel);
    public UserModel getUserByUsername(String username);

}
