package riste.kostadinov.graduation.project.domains;

import org.hibernate.annotations.Type;
import riste.kostadinov.graduation.project.configuration.AppointmentStatusConverter;
import riste.kostadinov.graduation.project.domains.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="date_time_from")
    private ZonedDateTime from;

    @Column(name="date_time_to")
    private ZonedDateTime to;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Resource resource;

    @Enumerated(EnumType.STRING)
    @Column(name = "status") // This points to the custom type handler
    private AppointmentStatus status;

    @ManyToOne()
    @JoinColumn(name="service_id")
    private DentalService dentalService;
}
