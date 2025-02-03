package com.bh.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpLoginModel {

    @NotEmpty(message = "email required")
    @Email(message = "invalid email format")
    private String email;

     @NotEmpty(message = "password required")
    @Size(min = 3,message = "password must greater than 3 chracter")
    private String password;
}
