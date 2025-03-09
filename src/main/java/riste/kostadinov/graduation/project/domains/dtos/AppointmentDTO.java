package riste.kostadinov.graduation.project.domains.dtos;

import java.time.ZonedDateTime;

public record AppointmentDTO(Long id, ZonedDateTime from, ZonedDateTime to) {
}
