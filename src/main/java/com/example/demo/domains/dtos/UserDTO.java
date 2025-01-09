package com.example.demo.domains.dtos;

import com.example.demo.domains.Role;

import java.util.Set;

public record UserDTO(String firstName, String lastName, Set<Role> roles) {
}
