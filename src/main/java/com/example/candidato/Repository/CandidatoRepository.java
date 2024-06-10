package com.example.candidato.Repository;


import com.example.candidato.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    // Custom query methods can be defined here
}

