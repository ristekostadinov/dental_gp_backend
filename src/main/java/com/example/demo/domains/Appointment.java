package com.example.demo.domains;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


}
