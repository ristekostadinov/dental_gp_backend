package com.example.demo.domains.dtos;

public record PatientRegistrationDTO(String firstName, String lastName, String email, String password, String phoneNumber, boolean insurance) {
}
