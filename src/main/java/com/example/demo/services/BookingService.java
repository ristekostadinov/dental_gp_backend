package com.example.demo.services;

import com.example.demo.domains.Booking;

import java.util.List;

public interface BookingService {
    Booking findById(Long id);
    Booking save(Booking treatment);
    List<Booking> findAll();
    void deleteById(Long id);
}
