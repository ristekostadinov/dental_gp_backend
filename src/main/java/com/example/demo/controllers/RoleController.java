package com.example.demo.controllers;

import com.example.demo.domains.Role;
import com.example.demo.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;
    @GetMapping
    public List<Role> getRoles(){
        return roleService.findAll();
    }
}
