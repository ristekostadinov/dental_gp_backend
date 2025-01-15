package com.example.demo.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "patients")
@Data
public class Patient implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "insurance")
    private boolean insurance;

    @Override
    public Patient clone() {
        try {
            return new Patient();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
