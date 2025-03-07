package com.example.demo.domains.dtos;

import java.time.ZonedDateTime;

public record BookingDTO(Long id, ZonedDateTime fromTimestamp, ZonedDateTime toTimestamp) {
}
