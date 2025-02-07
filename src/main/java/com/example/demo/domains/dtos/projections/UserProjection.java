package com.example.demo.domains.dtos.projections;

import com.example.demo.domains.Role;
import com.example.demo.domains.dtos.UserDTO;

import java.util.Set;

public interface UserProjection {
    Long getId();
    String getUsername();
    Set<Role> getRoles();

    default UserDTO toUserDTO() {
        return new UserDTO(getId(), getUsername(), getRoles());
    }
}
