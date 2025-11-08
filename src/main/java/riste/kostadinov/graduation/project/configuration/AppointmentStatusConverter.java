package riste.kostadinov.graduation.project.configuration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import riste.kostadinov.graduation.project.domains.enums.AppointmentStatus;

@Converter(autoApply = true)
public class AppointmentStatusConverter implements AttributeConverter<AppointmentStatus, String> {

    @Override
    public String convertToDatabaseColumn(AppointmentStatus status) {
        if (status == null) {
            return null;
        }
        // Convert Java Enum to its string name for the DB
        return status.name();
    }

    @Override
    public AppointmentStatus convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        // Convert DB string name back to Java Enum
        return AppointmentStatus.valueOf(dbData);
    }
}