package com.example.demo.domains;
import com.example.demo.domains.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;


@Entity
@Table(name="bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_time_from")
    private ZonedDateTime fromTimestamp;

    @Column(name="date_time_to")
    private ZonedDateTime toTimestamp;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
