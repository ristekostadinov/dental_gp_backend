package riste.kostadinov.graduation.project.domains.dtos;

import java.time.OffsetDateTime;

public record AppointmentRequest(OffsetDateTime fromDateTime, OffsetDateTime toDateTime, String patientEmail, Long resourceId, Long dentalServiceId) {
}
