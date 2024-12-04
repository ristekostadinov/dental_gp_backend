package com.example.demo.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Locale;

@Entity
@Table(name="roles")
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Override
    public String getAuthority() {
        return this.name.toUpperCase();
    }
}
