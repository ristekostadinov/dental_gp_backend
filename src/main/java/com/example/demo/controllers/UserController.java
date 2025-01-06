package com.example.demo.controllers;

import com.example.demo.domains.User;
import com.example.demo.domains.dtos.EditUserRequest;
import com.example.demo.domains.dtos.projections.UserView;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody EditUserRequest userRequest) {
        return new ResponseEntity<>(this.userService.editUser(id, userRequest), HttpStatus.OK);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserView>> listUsers() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }
}
