package com.example.demo.repositories;

import com.example.demo.domains.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
