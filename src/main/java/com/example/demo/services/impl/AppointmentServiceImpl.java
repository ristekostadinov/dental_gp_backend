package com.example.demo.services.impl;

import com.example.demo.domains.dtos.AppointmentRequest;
import com.example.demo.domains.dtos.DoctorDTO;
import com.example.demo.repositories.AppointmentRepository;
import com.example.demo.services.AppointmentService;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;
    private final UserService userService;

    @Override
    public void create(AppointmentRequest request) {
    }
}
