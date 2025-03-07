package com.example.demo.services;

import com.example.demo.domains.User;
import com.example.demo.domains.dtos.DoctorDTO;
import com.example.demo.domains.dtos.EditUserRequest;
import com.example.demo.domains.dtos.SignUpRequest;
import com.example.demo.domains.dtos.UserDTO;

import java.util.List;


public interface UserService {
    User create(SignUpRequest request);
    User findById(Long id);
    List<UserDTO> listAll();
    User editUser(Long id, EditUserRequest editUserRequest);
    User findByEmail(String email);
    void delete(Long id);
    List<DoctorDTO> findAllDoctors();
}
