package com.example.demo.services.impl;

import com.example.demo.domains.User;
import com.example.demo.domains.dtos.EditUserRequest;
import com.example.demo.domains.dtos.SignUpRequest;
import com.example.demo.domains.dtos.UserDTO;
import com.example.demo.domains.dtos.projections.UserProjection;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final static String SUPER_ADMIN = "super@admin.com";

    @Transactional
    public User create(SignUpRequest request){
        log.info("Create user with username  {} and email {}", request.username(), request.email());
        var user = new User();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRoles(new HashSet<>());
        log.info("Created user with username  {} and email {}", request.username(), request.email());
        return repository.save(user);
    }
    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User with id " + id + " not found"));
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(()-> new UserNotFoundException("User with email " + email + " not found"));
    }

    public List<UserDTO> listAll() {
        return this.repository.findAllByEmailNotLike(SUPER_ADMIN)
                .stream()
                .map(UserProjection::toUserDTO)
                .toList();
    }

    @Transactional
    public User editUser(Long id, EditUserRequest editUserRequest){
        log.info("Edit user with username {} and email {}", id, editUserRequest.email());
        User user = this.findById(id);
        user.setFirstName(editUserRequest.firstname());
        user.setLastName(editUserRequest.lastname());
        user.setUsername(editUserRequest.username());
        user.setEmail(editUserRequest.email());
        user.setPassword(passwordEncoder.encode(editUserRequest.password()));
        user.setRoles(editUserRequest.roles());
        log.info("Edited user with username {} and email {}", id, editUserRequest.email());
        return repository.save(user);
    }

    public void delete(Long id){
        log.info("Delete user with username {}", id);
        this.repository.deleteById(id);
    }
}
