package riste.kostadinov.graduation.project.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import riste.kostadinov.graduation.project.repositories.DentalServiceRepository;
import riste.kostadinov.graduation.project.services.DentalServiceManager;

@Service
@AllArgsConstructor
public class DentalServiceManagerImpl implements DentalServiceManager {
    private final DentalServiceRepository repository;
}
