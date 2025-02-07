package com.example.demo.domains;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="treatments")
@Data
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
}
