package com.instagram.insta.dto.user.request;

public class LoginRequest {
    private long id;
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
