package com.example.demo.domains.dtos.projections;

import com.example.demo.domains.Role;

import java.util.Set;

public interface UserView {
    Long getId();
    String getUsername();
    Set<Role> getRoles();
}
