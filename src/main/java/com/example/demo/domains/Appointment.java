package com.example.demo.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "appointment_date")
    private ZonedDateTime date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Patient patient;
}
