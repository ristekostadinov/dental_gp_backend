package com.example.demo.services;

import com.example.demo.domains.Role;

import java.util.Optional;

public interface UserRoleService {
    Optional<Role> findById(Long id);
}
