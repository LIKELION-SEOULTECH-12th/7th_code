package com.instagram.insta.service;

import com.instagram.insta.domain.User.User;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(UserCreateRequest userCreateRequest) {
        User user = new User();
        user.setName(userCreateRequest.getName());
        user.setNickname(userCreateRequest.getNickname());
        user.setEmail(userCreateRequest.getEmail());
        user.setPassword(userCreateRequest.getPassword());
        userRepository.save(user);
    }

    @Transactional
    public boolean logIn(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
        return user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword());
    }

    @Transactional
    public String logOut() {
        return "redirect:/login";
    } // 로그아웃 부분 조금 더 알아볼 예정

    @Transactional
    public List<UserResponse> getUser() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getNickname(), user.getEmail()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UserUpdateRequest userUpdateRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(userUpdateRequest.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userUpdateRequest.getName());
            user.setNickname(userUpdateRequest.getNickname());
            user.setEmail(userUpdateRequest.getEmail());
            user.setPassword(userUpdateRequest.getPassword());
            userRepository.save(user);
        }
    }
}
