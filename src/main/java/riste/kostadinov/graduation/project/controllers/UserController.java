package riste.kostadinov.graduation.project.controllers;
import riste.kostadinov.graduation.project.domains.User;
import riste.kostadinov.graduation.project.domains.dtos.EditUserRequest;
import riste.kostadinov.graduation.project.domains.dtos.UserDTO;
import riste.kostadinov.graduation.project.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody EditUserRequest userRequest) {
        log.debug("request for Edit User");
        return new ResponseEntity<>(this.userService.editUser(id, userRequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listUsers() {
        return new ResponseEntity<>(this.userService.listAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.userService.delete(id);
    }
}
