package com.example.demo.services;

import com.example.demo.domains.User;
import com.example.demo.domains.dtos.EditUserRequest;
import com.example.demo.domains.dtos.SignUpRequest;
import com.example.demo.domains.dtos.UserDTO;

import java.util.List;


public interface UserService {
    User save(User user);
    User save(SignUpRequest request);
    User findById(Long id);
    List<User> findAll();
    User editUser(Long id, EditUserRequest editUserRequest);
}
