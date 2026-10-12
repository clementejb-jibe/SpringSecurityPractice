package com.example.springsecuritypractice.dto;

import com.example.springsecuritypractice.entity.Role;

public record UserResponse(
        Long id,
        String username,
        Role role
) {
}
