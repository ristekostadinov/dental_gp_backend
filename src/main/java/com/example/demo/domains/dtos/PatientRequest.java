package com.example.demo.domains.dtos;

public record PatientRequest(String firstName, String lastName, String email, String phoneNumber, boolean insurance) {
}
