package riste.kostadinov.graduation.project.repositories;

import org.springframework.data.jpa.repository.Query;
import riste.kostadinov.graduation.project.domains.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import riste.kostadinov.graduation.project.domains.dtos.projections.ResourceServiceProjection;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    @Query(value = "select id, name, address, description, price from (select r.id as id, r.name as name, r.address as address, r.description as description from resources r where r.location_id=:locationId) as r2 join resource_service on id=resource_id and service_id=:serviceId ", nativeQuery = true)
    List<ResourceServiceProjection> findResourcesWithLocationIdAndServiceId(Long locationId, Long serviceId);
}
