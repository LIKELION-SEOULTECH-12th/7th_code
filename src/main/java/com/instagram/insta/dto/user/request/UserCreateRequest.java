package com.instagram.insta.dto.user.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
    private String name;
    private String nickname;
    private String email;
    private String password;

}
