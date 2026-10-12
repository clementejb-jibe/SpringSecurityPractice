package com.example.springsecuritypractice.controller;

import com.example.springsecuritypractice.dto.RegisterRequest;
import com.example.springsecuritypractice.dto.UserResponse;
import com.example.springsecuritypractice.repository.UserRepository;
import com.example.springsecuritypractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest registerRequest) {

        return userService.createUser(registerRequest);
    }

}
