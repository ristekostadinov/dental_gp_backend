package com.example.demo.domains.dtos.projections;

import com.example.demo.domains.dtos.AppointmentDTO;

import java.time.ZonedDateTime;

public interface AppointmentProjection {
    Long getId();
    ZonedDateTime getDate();

    default AppointmentDTO toDTO(){
        return new AppointmentDTO(getId(), getDate());
    }
}
