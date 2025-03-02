package com.example.demo.services;

import com.example.demo.domains.Appointment;
import com.example.demo.domains.dtos.AppointmentRequest;

import java.time.ZonedDateTime;
import java.util.List;

public interface AppointmentService {
    void create(AppointmentRequest request);
    Appointment findById(Long id);
    List<Appointment> findAllByDate(ZonedDateTime date);
    void delete(Long id);
}
