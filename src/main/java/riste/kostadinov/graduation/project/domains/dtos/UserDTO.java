package riste.kostadinov.graduation.project.domains.dtos;

import riste.kostadinov.graduation.project.domains.Role;

import java.util.Set;


public record UserDTO(Long id, String username, Set<Role> roles) {
}