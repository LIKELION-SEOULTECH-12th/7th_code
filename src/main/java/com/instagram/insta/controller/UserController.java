package com.instagram.insta.controller;

import com.instagram.insta.dto.user.request.LoginRequest;
import com.instagram.insta.dto.user.request.UserCreateRequest;
import com.instagram.insta.dto.user.request.UserUpdateRequest;
import com.instagram.insta.dto.user.response.UserResponse;
import com.instagram.insta.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("insta/user")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public void saveUser(@RequestBody UserCreateRequest userCreateRequest){}

    @PostMapping("/login")
    public void logIn(@RequestBody LoginRequest loginRequest){}

    @PostMapping("/logout")
    public void logOut(){} // 로그아웃 부분 조금 더 알아볼 예정

    @GetMapping("/info")
    public List<UserResponse> getUser(){
        return UserService.getUser();
    }

    @PutMapping("/info")
    public void updateUser(@RequestBody UserUpdateRequest userUpdateRequest){

    }
}
