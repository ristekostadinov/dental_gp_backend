package com.example.demo.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;


@Entity
@Table(name="bookings")
@Data
public class Booking {
    enum Status{CREATED, IN_PROGRESS, BOOKED, CANCELLED, REALIZED}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_time_from")
    private ZonedDateTime from;

    @Column(name="date_time_to")
    private ZonedDateTime to;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
