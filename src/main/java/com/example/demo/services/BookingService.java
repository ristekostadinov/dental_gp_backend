package com.example.demo.services;

import com.example.demo.domains.Booking;
import com.example.demo.domains.dtos.BookingDTO;
import com.example.demo.domains.dtos.BookingRequest;

import java.util.List;

public interface BookingService {
    Booking findById(Long id);
    Booking save(BookingRequest bookingRequest);
    List<BookingDTO> findAll();
    void deleteById(Long id);
}
