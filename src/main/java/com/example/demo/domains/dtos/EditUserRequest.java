package com.example.demo.domains.dtos;

import com.example.demo.domains.Role;

import java.util.Set;

public record EditUserRequest(String firstname, String lastname, String email, String username, String password, Set<Role> roles) {
}
