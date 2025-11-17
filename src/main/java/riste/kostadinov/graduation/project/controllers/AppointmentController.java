package riste.kostadinov.graduation.project.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import riste.kostadinov.graduation.project.domains.Appointment;
import riste.kostadinov.graduation.project.domains.dtos.AppointmentRequest;
import riste.kostadinov.graduation.project.domains.dtos.PatientAppointmentDTO;
import riste.kostadinov.graduation.project.domains.dtos.projections.AppointmentProjection;
import riste.kostadinov.graduation.project.services.AppointmentService;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@AllArgsConstructor
@Slf4j
public class AppointmentController {
    private final AppointmentService service;

    @PostMapping("create")
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        log.info("request hit this endpoint");
        return new ResponseEntity<>(this.service.save(appointmentRequest), HttpStatus.OK);
    }

    @GetMapping("all/{email}")
    public ResponseEntity<List<PatientAppointmentDTO>> getAllAppointments(@PathVariable String email) {
        return new ResponseEntity<>(this.service.getBookedAppointmentsByPatient(email), HttpStatus.OK);
    }

    @PutMapping("{id}/cancel")
    public ResponseEntity<Appointment> cancelAppointment(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.cancel(id), HttpStatus.OK);
    }

}
