package com.example.demo.services;

import com.example.demo.domains.dtos.AppointmentRequest;

public interface AppointmentService {
    void create(AppointmentRequest request);
}
