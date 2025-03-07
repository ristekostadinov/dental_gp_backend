package com.example.demo.domains;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
