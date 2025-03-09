package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    List<Role> findAllByIdIn(List<Long> ids);
}
