package com.kashful.erp.security.config;

public class AuthRequest {
    private String username;
    private String password;
    private String jwt;

    // Default constructor
    public AuthRequest(String jwt) {
    	this.jwt=jwt;
    }

    // Parameterized constructor
    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    AuthRequest(){
    	
    }
}
