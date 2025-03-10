package riste.kostadinov.graduation.project.domains.dtos;

import riste.kostadinov.graduation.project.domains.Role;

import java.util.Set;

public record JwtAuthenticationResponse(String token, String username, String email, Set<Role> roles) {
}
