package com.instagram.insta.dto.user.response;

public class UserResponse {
    private long id;
    private String name;
    private String nickname;
    private String email;

    public UserResponse(long id, String name, String nickname, String email) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
    }
}
