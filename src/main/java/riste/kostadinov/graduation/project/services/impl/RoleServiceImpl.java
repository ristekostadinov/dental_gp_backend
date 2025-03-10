package riste.kostadinov.graduation.project.services.impl;

import riste.kostadinov.graduation.project.domains.Role;
import riste.kostadinov.graduation.project.repositories.RoleRepository;
import riste.kostadinov.graduation.project.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public List<Role> findAll() {
        return this.repository.findAllByNameNotLike("SUPER_ADMIN");
    }

    @Override
    public List<Role> findAllByIdIn(List<Long> ids) {
        return repository.findAllByIdIn(ids);
    }
}
