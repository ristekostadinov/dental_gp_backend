package com.example.demo.services;

import com.example.demo.domains.User;

public interface UserService {
    public User save(User user);
    public User findById(Long id);
}
