package com.example.candidato.Repository;

import com.example.candidato.model.Educacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducacaoRepository extends JpaRepository<Educacao, Long> {
    // Custom query methods can be defined here
}
