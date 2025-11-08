package riste.kostadinov.graduation.project.services.impl;

import riste.kostadinov.graduation.project.domains.Role;
import riste.kostadinov.graduation.project.domains.User;
import riste.kostadinov.graduation.project.domains.dtos.DoctorDTO;
import riste.kostadinov.graduation.project.domains.dtos.EditUserRequest;
import riste.kostadinov.graduation.project.domains.dtos.SignUpRequest;
import riste.kostadinov.graduation.project.domains.dtos.UserDTO;
import riste.kostadinov.graduation.project.domains.dtos.projections.DoctorProjection;
import riste.kostadinov.graduation.project.domains.dtos.projections.UserProjection;
import riste.kostadinov.graduation.project.exceptions.UserNotFoundException;
import riste.kostadinov.graduation.project.exceptions.UserAlreadyExistException;
import riste.kostadinov.graduation.project.repositories.UserRepository;
import riste.kostadinov.graduation.project.services.RoleService;
import riste.kostadinov.graduation.project.services.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final RoleService roleService;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final static String SUPER_ADMIN = "super@admin.com";

    @Transactional
    public User create(SignUpRequest request){
        log.info("Create user with username  {} and email {}", request.username(), request.email());
        if(this.repository.findByEmail(request.email()).isPresent()){
            throw new UserAlreadyExistException("User with email "+request.email()+" already exists");
        }
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
        log.info("Request object {} ", editUserRequest);
        User user = this.findById(id);
        Set<Role> roles = new HashSet<>(this.roleService.findAllByIdIn(editUserRequest.rolesId()));
        user.setFirstName(editUserRequest.firstName());
        user.setLastName(editUserRequest.lastName());
        user.setUsername(editUserRequest.username());
        user.setEmail(editUserRequest.email());
        if(!user.getPassword().equals(editUserRequest.password())){
            user.setPassword(passwordEncoder.encode(editUserRequest.password()));
        }
        user.setRoles(roles);
        log.info("Edited user with firstname {} username {} and email {}", editUserRequest.firstName(), editUserRequest.username(), editUserRequest.email());
        log.info("User roles are {}", user.getRoles());
        return repository.save(user);
    }

    public void delete(Long id){
        log.info("Delete user with username {}", id);
        this.repository.deleteById(id);
    }

    @Override
    public List<DoctorDTO> findAllDoctors() {
        return this.repository
                .findAllDoctors()
                .stream()
                .map(DoctorProjection::toDTO)
                .toList();
    }
}
