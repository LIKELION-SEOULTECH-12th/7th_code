package com.instagram.insta.dto.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private long id;
    private String name;
    private String nickname;
    private String email;

}
