package riste.kostadinov.graduation.project.repositories;

import riste.kostadinov.graduation.project.domains.User;
import riste.kostadinov.graduation.project.domains.dtos.projections.DoctorProjection;
import riste.kostadinov.graduation.project.domains.dtos.projections.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<UserProjection> findAllByEmailNotLike(String email);

    @Query("select u.id as id, u.firstName as firstName, u.lastName as lastName from User u join u.roles as r where r.name LIKE 'DOCTOR' ")
    List<DoctorProjection> findAllDoctors();
}
