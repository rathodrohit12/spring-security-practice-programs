package com.rohit.springsecuritydemo.usermodule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private Long id;
    private String email;
    private String password;
    private String mobileNumber;

    private String role;

}
