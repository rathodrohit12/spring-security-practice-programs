package com.bh.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpOTPModel {

    @NotEmpty(message = "email required")
    @Email(message = "invalid email format")
    private String email;

    @NotEmpty(message = "otp required")
    private String otp;


}
