package riste.kostadinov.graduation.project.domains.dtos;

import java.time.ZonedDateTime;

public record BookingDTO(Long id, ZonedDateTime fromTimestamp, ZonedDateTime toTimestamp) {
}
