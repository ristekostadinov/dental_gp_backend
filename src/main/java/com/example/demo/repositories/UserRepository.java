package com.example.demo.repositories;

import com.example.demo.domains.User;
import com.example.demo.domains.dtos.projections.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<UserView> listUsers();
}
