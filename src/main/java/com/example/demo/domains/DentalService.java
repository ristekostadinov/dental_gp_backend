package com.example.demo.domains;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "services")
@Data
public class DentalService {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
}
