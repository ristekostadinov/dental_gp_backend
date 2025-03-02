package com.example.demo.domains.dtos;

import java.time.ZonedDateTime;

public record AppointmentRequest(Long id, ZonedDateTime dateTime, Long userId, Long patientId) {
}
