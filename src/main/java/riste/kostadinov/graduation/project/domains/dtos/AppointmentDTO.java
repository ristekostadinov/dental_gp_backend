package riste.kostadinov.graduation.project.domains.dtos;


import java.time.OffsetDateTime;

public record AppointmentDTO(Long id, OffsetDateTime fromDateTime, OffsetDateTime toDateTime) {}
