package com.example.candidato.Service;


import com.example.candidato.Repository.ExperienciaProfissionalRepository;
import com.example.candidato.model.ExperienciaProfissional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ExperienciaProfissionalService {

    @Autowired
    private ExperienciaProfissionalRepository experienciaProfissionalRepository;

    public List<ExperienciaProfissional> findAll() {
        return experienciaProfissionalRepository.findAll();
    }

    public Optional<ExperienciaProfissional> findById(Long id) {
        return experienciaProfissionalRepository.findById(id);
    }

    public ExperienciaProfissional save(ExperienciaProfissional experienciaProfissional) {
        return experienciaProfissionalRepository.save(experienciaProfissional);
    }

    public void deleteById(Long id) {
        experienciaProfissionalRepository.deleteById(id);
    }
}
