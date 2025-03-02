package com.example.demo.repositories;

import com.example.demo.domains.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByDate(ZonedDateTime date);
}
