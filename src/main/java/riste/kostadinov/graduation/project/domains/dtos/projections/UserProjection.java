package riste.kostadinov.graduation.project.domains.dtos.projections;

import riste.kostadinov.graduation.project.domains.Role;
import riste.kostadinov.graduation.project.domains.dtos.UserDTO;

import java.util.Set;

public interface UserProjection {
    Long getId();
    String getUsername();
    Set<Role> getRoles();


    default UserDTO toUserDTO() {
        return new UserDTO(getId(), getUsername(), getRoles());
    }
}
