package com.example.demo.domains.dtos;

import com.example.demo.domains.Role;

import java.util.List;
import java.util.Set;

public record EditUserRequest(String firstName, String lastName, String username, String email, String password, List<Long> rolesId) {
}
