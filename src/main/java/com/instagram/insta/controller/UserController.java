package com.instagram.insta.controller;

import com.instagram.insta.dto.user.request.LoginRequest;
import com.instagram.insta.dto.user.request.UserCreateRequest;
import com.instagram.insta.dto.user.request.UserUpdateRequest;
import com.instagram.insta.dto.user.response.UserResponse;
import com.instagram.insta.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
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
    public void saveUser(@RequestBody UserCreateRequest userCreateRequest){
        System.out.println("Received UserCreateRequest: " + userCreateRequest);
        userService.saveUser(userCreateRequest);
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String logIn(@RequestBody LoginRequest loginRequest, HttpSession session, Model model){
        if (userService.logIn(loginRequest)){
            session.setAttribute("user", loginRequest.getEmail());
            return "redirect:/home";
        }
        else {
            model.addAttribute("error", "Invalid email or pasword");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session){
        return userService.logOut();
    } // 로그아웃 부분 조금 더 알아볼 예정

    @GetMapping("/info")
    public List<UserResponse> getUser(){
        return userService.getUser();
    }

    @PutMapping("/info")
    public void updateUser(@RequestBody UserUpdateRequest userUpdateRequest){
        userService.updateUser(userUpdateRequest);
    }
}
