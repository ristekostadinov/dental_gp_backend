package riste.kostadinov.graduation.project.domains.dtos;

import java.time.ZonedDateTime;

public record AppointmentRequest(ZonedDateTime from, ZonedDateTime to,  String patientEmail, Long resourceId,Long dentalServiceId) {
}
