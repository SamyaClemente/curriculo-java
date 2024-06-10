package com.example.candidato.Repository;


import com.example.candidato.model.ExperienciaProfissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienciaProfissionalRepository extends JpaRepository<ExperienciaProfissional, Long> {
    // Custom query methods can be defined here
}
