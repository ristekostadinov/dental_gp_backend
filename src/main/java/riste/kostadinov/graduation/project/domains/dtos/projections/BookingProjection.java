package riste.kostadinov.graduation.project.domains.dtos.projections;
import riste.kostadinov.graduation.project.domains.dtos.BookingDTO;

import java.time.ZonedDateTime;

public interface BookingProjection {
    Long getId();
    ZonedDateTime getFromTimestamp();
    ZonedDateTime getToTimestamp();

    default BookingDTO toBookingDTO(){
        return new BookingDTO(getId(), getFromTimestamp(), getToTimestamp());
    }
}
