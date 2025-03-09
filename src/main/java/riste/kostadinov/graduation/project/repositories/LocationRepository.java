package riste.kostadinov.graduation.project.repositories;

import riste.kostadinov.graduation.project.domains.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
