package riste.kostadinov.graduation.project.domains.dtos;

import java.time.ZonedDateTime;

public record AppointmentRequest(Long id, ZonedDateTime from, ZonedDateTime to, Long userId, Long patientId) {
}
