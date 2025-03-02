package com.example.demo.domains.dtos;

import java.time.ZonedDateTime;

public record AppointmentDTO(Long id, ZonedDateTime date, String time) {
}
