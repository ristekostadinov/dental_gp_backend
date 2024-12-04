package com.example.demo.domains.dtos;

public record ChangePasswordRequest(String oldPassword, String newPassword) {
}
