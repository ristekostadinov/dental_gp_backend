package com.example.demo.services.impl;

import com.example.demo.domains.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
