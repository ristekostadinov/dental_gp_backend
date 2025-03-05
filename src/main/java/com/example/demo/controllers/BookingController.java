package com.example.demo.controllers;

import com.example.demo.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;

}
