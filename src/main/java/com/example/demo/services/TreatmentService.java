package com.example.demo.services;

import com.example.demo.domains.Treatment;

import java.util.List;

public interface TreatmentService {
    Treatment findById(Long id);
    Treatment save(Treatment treatment);
    List<Treatment> findAll();
    void deleteById(Long id);
}
