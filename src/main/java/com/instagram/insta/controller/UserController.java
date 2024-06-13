package com.instagram.insta.controller;

import com.instagram.insta.domain.User.User;
import com.instagram.insta.domain.User.UserRepository;
import com.instagram.insta.dto.user.request.LoginRequest;
import com.instagram.insta.dto.user.request.UserCreateRequest;
import com.instagram.insta.dto.user.request.UserUpdateRequest;
import com.instagram.insta.dto.user.response.UserResponse;
import com.instagram.insta.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/insta/user")
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;


    @PostMapping("/signup")
    public String saveUser(@RequestBody UserCreateRequest userCreateRequest){
        userService.saveUser(userCreateRequest);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody LoginRequest loginRequest, HttpSession session){
        UserResponse userResponse = userService.logIn(loginRequest);
        if(userResponse != null){
            session.setAttribute("userId", userResponse.getId());
            return ResponseEntity.ok(userResponse);
        }else{
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session){
        return userService.logOut();
    } // 로그아웃 부분 조금 더 알아볼 예정

//    public List<UserResponse> getUser(){
//        return userService.getUser();
//    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable("userId") Long userId) {
        // 데이터베이스에서 userId로 사용자 조회
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            // 사용자가 존재하는 경우 UserResponse 객체로 변환하여 반환
            User foundUser = user.get();
            UserResponse userResponse = new UserResponse(
                    foundUser.getId(),
                    foundUser.getName(),
                    foundUser.getNickname(),
                    foundUser.getEmail()
            );
            return ResponseEntity.ok(userResponse);
        } else {
            // 사용자가 존재하지 않는 경우 404 Not Found 반환
            return ResponseEntity.status(404).body(null);
        }
    }
    @PutMapping("/info")
    public void updateUser(@RequestBody UserUpdateRequest userUpdateRequest){
        userService.updateUser(userUpdateRequest);
    }
}
