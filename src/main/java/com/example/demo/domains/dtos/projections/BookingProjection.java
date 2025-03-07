package com.example.demo.domains.dtos.projections;
import com.example.demo.domains.dtos.BookingDTO;

import java.time.ZonedDateTime;

public interface BookingProjection {
    Long getId();
    ZonedDateTime getFromTimestamp();
    ZonedDateTime getToTimestamp();

    default BookingDTO toBookingDTO(){
        return new BookingDTO(getId(), getFromTimestamp(), getToTimestamp());
    }
}
