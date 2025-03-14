package riste.kostadinov.graduation.project.domains.dtos;

import java.time.ZonedDateTime;

public record BookingRequest(ZonedDateTime from, ZonedDateTime to, Long patientId, Long resourceId) {
}
