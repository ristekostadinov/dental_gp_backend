package riste.kostadinov.graduation.project.repositories;

import riste.kostadinov.graduation.project.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
    List<Role> findAllByNameNotLike(String name);
    List<Role> findAllByIdIn(List<Long> ids);
}
