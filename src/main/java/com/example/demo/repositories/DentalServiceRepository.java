package com.example.demo.repositories;

import com.example.demo.domains.DentalService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentalServiceRepository extends JpaRepository<DentalService,Long> {
}
