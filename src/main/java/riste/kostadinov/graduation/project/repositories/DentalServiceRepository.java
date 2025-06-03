package riste.kostadinov.graduation.project.repositories;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import riste.kostadinov.graduation.project.domains.DentalService;
import org.springframework.data.jpa.repository.JpaRepository;
import riste.kostadinov.graduation.project.domains.dtos.DentalServiceDTO;
import riste.kostadinov.graduation.project.domains.dtos.projections.DentalServiceProjection;

import java.util.List;

public interface DentalServiceRepository extends JpaRepository<DentalService,Long> {

    @Query(value = "SELECT s.id, s.name FROM services s WHERE s.category_id = :categoryId AND " +
            "s.id IN (select service_id from location_service WHERE location_id=:locationId)", nativeQuery = true)
    List<DentalServiceProjection> findAllDentalServices(Long categoryId, Long locationId);
}
