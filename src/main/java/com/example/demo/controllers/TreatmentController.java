package com.example.demo.controllers;

import com.example.demo.domains.Treatment;
import com.example.demo.services.TreatmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/treatments")
@AllArgsConstructor
public class TreatmentController {
    private final TreatmentService treatmentService;

    @GetMapping("/")
    public ResponseEntity<List<Treatment>> getAllTreatments() {

    }
}
