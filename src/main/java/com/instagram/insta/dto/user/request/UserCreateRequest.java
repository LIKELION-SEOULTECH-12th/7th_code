package com.instagram.insta.dto.user.request;

public class UserCreateRequest {
    private String name;
    private String nickname;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
