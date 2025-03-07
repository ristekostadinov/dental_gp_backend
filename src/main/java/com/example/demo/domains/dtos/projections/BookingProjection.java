package com.example.demo.domains.dtos.projections;
import com.example.demo.domains.dtos.BookingDTO;

import java.time.ZonedDateTime;

public interface BookingProjection {
    Long getId();
    ZonedDateTime getFrom();
    ZonedDateTime getTo();

    default BookingDTO toDTO(){
        return new BookingDTO(getId(), getFrom(), getTo());
    }
}
