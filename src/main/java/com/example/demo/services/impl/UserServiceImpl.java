package com.example.demo.services.impl;

import com.example.demo.domains.Role;
import com.example.demo.domains.User;
import com.example.demo.domains.dtos.EditUserRequest;
import com.example.demo.domains.dtos.SignUpRequest;
import com.example.demo.domains.dtos.UserDTO;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public User save(User user) {
        return repository.save(user);
    }

    @Transactional
    public User save(SignUpRequest request){
        var user = new User();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRoles(new HashSet<>());

        return repository.save(user);
    }
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("User with email " + email + " not found"));
    }

    public List<UserDTO> findAllUsersByRoles() {
        List<Role> roles = roleService.findAll();
        return this.repository.findAllByRoles(roles);
    }

    @Transactional
    public User editUser(Long id, EditUserRequest editUserRequest){
        User user = this.findById(id);
        user.setFirstName(editUserRequest.firstname());
        user.setLastName(editUserRequest.lastname());
        user.setUsername(editUserRequest.username());
        user.setEmail(editUserRequest.email());
        user.setPassword(passwordEncoder.encode(editUserRequest.password()));
        user.setRoles(editUserRequest.roles());
        return repository.save(user);
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }
}
