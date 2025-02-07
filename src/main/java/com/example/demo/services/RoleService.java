package com.example.demo.services;

import com.example.demo.domains.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> findAll();
    List<Role> findAllByIdIn(List<Long> ids);
}
