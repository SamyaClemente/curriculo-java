package com.example.candidato.Service;


import com.example.candidato.Repository.CandidatoRepository;
import com.example.candidato.model.Candidato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public List<Candidato> findAll() {
        return candidatoRepository.findAll();
    }

    public Optional<Candidato> findById(Long id) {
        return candidatoRepository.findById(id);
    }

    public Candidato save(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    public void deleteById(Long id) {
        candidatoRepository.deleteById(id);
    }
}
