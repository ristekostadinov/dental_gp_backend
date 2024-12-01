package com.example.demo.domains.dtos;

import com.example.demo.domains.Role;

import java.util.Set;

public record JwtAuthenticationResponse(String token, String username, String email, Set<Role> roles) {
}
