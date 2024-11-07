package com.example.demo.repositories;

import com.example.demo.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsEmail(String email);
    void saveUser(User user);
    Optional<User> findByEmail(String email);
}
