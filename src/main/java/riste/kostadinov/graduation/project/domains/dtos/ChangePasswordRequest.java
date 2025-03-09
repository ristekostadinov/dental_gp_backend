package riste.kostadinov.graduation.project.domains.dtos;

public record ChangePasswordRequest(String oldPassword, String newPassword) {
}
