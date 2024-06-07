package com.instagram.insta.service;

import com.instagram.insta.domain.User.UserRepository;
import com.instagram.insta.dto.user.request.LoginRequest;
import com.instagram.insta.dto.user.request.UserCreateRequest;
import com.instagram.insta.dto.user.request.UserUpdateRequest;
import com.instagram.insta.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(UserCreateRequest userCreateRequest){}

    @Transactional
    public void logIn(LoginRequest loginRequest){}

    @Transactional
    public void logOut(){} // 로그아웃 부분 조금 더 알아볼 예정

    @Transactional
    public List<UserResponse> getUser(){
    }

    @Transactional
    public void updateUser(UserUpdateRequest userUpdateRequest){

    }
}
