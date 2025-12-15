package riste.kostadinov.graduation.project.domains.dtos;

public record PatientRequest(String firstName, String lastName, String email, String phoneNumber, boolean insurance, String password) {
}
