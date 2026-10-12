package com.example.springsecuritypractice.dto;

import com.example.springsecuritypractice.entity.User;

public class UserMapper {
    private UserMapper() {
    }

    public static User toEntity(RegisterRequest registerRequest) {
        User user = new User();

        user.setUsername(registerRequest.username());
        user.setPassword(registerRequest.password());


        return user;
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getRole()
        );
    }
}
