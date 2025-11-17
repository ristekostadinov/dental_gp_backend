package riste.kostadinov.graduation.project.domains.dtos;

import java.time.OffsetDateTime;

public record PatientAppointmentDTO(Long id, String resourceName, String dentalServiceName, OffsetDateTime fromDateTime, OffsetDateTime toDateTime) {}
