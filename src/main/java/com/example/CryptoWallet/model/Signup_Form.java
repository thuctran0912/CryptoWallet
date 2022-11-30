package com.example.CryptoWallet.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Signup_Form { // Object to store data from the signup html page
	@NotEmpty
	private String email = "";
	
	@NotEmpty
    @Size(min=5, max=30)
    private String username = "";
	
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotEmpty
    @Size(min=7, max=30)
    private String password = "";
	
    @NotEmpty
    @Size(min=7, max=30)
    private String passwordCheck = "";
    
    @NotEmpty
    private String role = "USER";
    
    @NotEmpty
    private String firstName = "";
    
    @NotEmpty
    private String lastName = "";
    
    

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

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

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
}
    
    
