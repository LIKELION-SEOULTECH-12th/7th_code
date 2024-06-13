package com.instagram.insta.dto.user.request;

import lombok.Getter;

@Getter
public class LoginRequest {
    private long id;
    private String email;
    private String password;
}
