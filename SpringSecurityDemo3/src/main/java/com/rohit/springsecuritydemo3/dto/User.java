package com.rohit.springsecuritydemo3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;

    private String name;
    private String email;
    private String password;
    private String phone;
}
