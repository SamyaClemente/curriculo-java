package com.example.candidato.Service;


import com.example.candidato.Repository.HabilidadeRepository;
import com.example.candidato.model.Habilidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabilidadeService {

    @Autowired
    private HabilidadeRepository habilidadeRepository;

    public List<Habilidade> findAll() {
        return habilidadeRepository.findAll();
    }

    public Optional<Habilidade> findById(Long id) {
        return habilidadeRepository.findById(id);
    }

    public Habilidade save(Habilidade habilidade) {
        return habilidadeRepository.save(habilidade);
    }

    public void deleteById(Long id) {
        habilidadeRepository.deleteById(id);
    }
}
