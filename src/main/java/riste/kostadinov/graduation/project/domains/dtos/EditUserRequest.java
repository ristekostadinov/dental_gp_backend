package riste.kostadinov.graduation.project.domains.dtos;

import java.util.List;

public record EditUserRequest(String firstName, String lastName, String username, String email, String password, List<Long> rolesId) {
}
