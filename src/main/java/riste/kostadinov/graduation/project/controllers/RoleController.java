package riste.kostadinov.graduation.project.controllers;

import riste.kostadinov.graduation.project.domains.Role;
import riste.kostadinov.graduation.project.services.RoleService;
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
