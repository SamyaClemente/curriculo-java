package com.example.candidato.Service;


import com.example.candidato.Repository.EducacaoRepository;
import com.example.candidato.model.Educacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducacaoService {

    @Autowired
    private EducacaoRepository educacaoRepository;

    public List<Educacao> findAll() {
        return educacaoRepository.findAll();
    }

    public Optional<Educacao> findById(Long id) {
        return educacaoRepository.findById(id);
    }

    public Educacao save(Educacao educacao) {
        return educacaoRepository.save(educacao);
    }

    public void deleteById(Long id) {
        educacaoRepository.deleteById(id);
    }
}
