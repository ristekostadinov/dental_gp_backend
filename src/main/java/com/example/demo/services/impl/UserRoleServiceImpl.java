package com.example.demo.services.impl;

import com.example.demo.domains.Role;
import com.example.demo.services.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Override
    public Optional<Role> findById(Long id) {
        return Optional.empty();
    }
}
