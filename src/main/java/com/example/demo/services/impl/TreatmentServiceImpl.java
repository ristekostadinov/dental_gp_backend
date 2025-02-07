package com.example.demo.services.impl;

import com.example.demo.domains.Treatment;
import com.example.demo.exceptions.TreatmentNotFoundException;
import com.example.demo.repositories.TreatmentRepository;
import com.example.demo.services.TreatmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TreatmentServiceImpl implements TreatmentService {
    private final TreatmentRepository repository;
    @Override
    public Treatment findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new TreatmentNotFoundException("Treatment with id:"+id+" not found"));
    }

    @Override
    public Treatment save(Treatment treatment) {
        return null;
    }

    @Override
    public List<Treatment> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {

    }
}
