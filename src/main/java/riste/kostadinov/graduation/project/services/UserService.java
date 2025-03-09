package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.User;
import riste.kostadinov.graduation.project.domains.dtos.DoctorDTO;
import riste.kostadinov.graduation.project.domains.dtos.EditUserRequest;
import riste.kostadinov.graduation.project.domains.dtos.SignUpRequest;
import riste.kostadinov.graduation.project.domains.dtos.UserDTO;

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
