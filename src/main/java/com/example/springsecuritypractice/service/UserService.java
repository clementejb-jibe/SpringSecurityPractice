package com.example.springsecuritypractice.service;

import com.example.springsecuritypractice.dto.RegisterRequest;
import com.example.springsecuritypractice.dto.UserMapper;
import com.example.springsecuritypractice.dto.UserResponse;
import com.example.springsecuritypractice.entity.Role;
import com.example.springsecuritypractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse createUser(RegisterRequest request) {

        if(request.username() == null || request.password() == null){
            throw new IllegalArgumentException("Username and password are required");
        }

        if(userRepository.findByUsername(request.username()).isPresent()){
            throw new IllegalArgumentException("Username already exists");
        }

        String encodedPassword = passwordEncoder.encode(request.password());

        var newUser = UserMapper.toEntity(request);

        newUser.setPassword(encodedPassword);

        newUser.setRole(Role.USER);

        var savedUser = userRepository.save(newUser);

        return UserMapper.toResponse(savedUser);
    }
}
