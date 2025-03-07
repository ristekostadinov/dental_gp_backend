package com.example.demo.services.impl;

import com.example.demo.domains.Appointment;
import com.example.demo.domains.dtos.AppointmentRequest;
import com.example.demo.domains.dtos.DoctorDTO;
import com.example.demo.exceptions.AppointmentNotFoundException;
import com.example.demo.repositories.AppointmentRepository;
import com.example.demo.services.AppointmentService;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;
    private final UserService userService;

    @Override
    public void create(AppointmentRequest request) {

    }

    @Override
    public Appointment findById(Long id) {
        return this.repository
                .findById(id)
                .orElseThrow(() ->  new AppointmentNotFoundException("Appointment with id " + id + " not found"));
    }


    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
