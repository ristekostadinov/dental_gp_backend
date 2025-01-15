package com.example.demo.services.impl;

import com.example.demo.domains.Role;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public List<Role> findAll() {
        return this.repository.findAllByNameNotLike("SUPER_ADMIN");
    }
}
