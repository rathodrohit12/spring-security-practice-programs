package com.bh.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpModel {

	

	@NotEmpty(message = "name required")
	@NotBlank(message = "name not be blank")
	@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
	private String name;
	
	@NotEmpty(message = "email required")
	@Email(message = "invalid email format")
	private String email;
	
	@Size(min = 10,max = 10,message = "mobile must be 10 digit")
	@NotEmpty(message = "Mobile number is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
	private String mobile;
	
	@NotEmpty(message = "password required")
	@Size(min = 3,message = "password must greater than 3 chracter")
	private String password;

	@NotEmpty(message = "status required")
	   private String status;

	@NotEmpty(message = "otp required")
	   private String otp;
}
