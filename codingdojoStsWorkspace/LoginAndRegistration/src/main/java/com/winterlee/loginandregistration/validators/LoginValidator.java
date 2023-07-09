package com.winterlee.loginandregistration.validators;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginValidator {

	@NotEmpty(message="Email is required.")
    @Email(message="Please enter a valid email.")
    private String email;
    
    @NotEmpty(message="Password is required.")
    @Size(min=8, message="Password must be at least 8 characters.")
    private String password;

	public LoginValidator() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
