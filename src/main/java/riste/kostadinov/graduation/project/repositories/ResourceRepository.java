package riste.kostadinov.graduation.project.repositories;

import riste.kostadinov.graduation.project.domains.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
