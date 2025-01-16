package com.example.demo.domains.dtos;

import com.example.demo.domains.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO{
    private String firstName;
    private String lastName;
    private String username;
    private Set<Role> roles;
}