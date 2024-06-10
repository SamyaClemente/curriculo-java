package com.example.candidato.Repository;


import com.example.candidato.model.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {
    // Custom query methods can be defined here
}
