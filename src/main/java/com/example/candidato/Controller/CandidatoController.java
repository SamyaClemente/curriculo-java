package com.example.candidato.Controller;


import com.example.candidato.Service.CandidatoService;
import com.example.candidato.model.Candidato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping
    public List<Candidato> getAllCandidatos() {
        return candidatoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidato> getCandidatoById(@PathVariable Long id) {
        Optional<Candidato> candidato = candidatoService.findById(id);
        return candidato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Candidato createCandidato(@RequestBody Candidato candidato) {
        return candidatoService.save(candidato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidato> updateCandidato(@PathVariable Long id, @RequestBody Candidato candidatoDetails) {
        Optional<Candidato> candidatoOptional = candidatoService.findById(id);
        if (candidatoOptional.isPresent()) {
            Candidato candidato = candidatoOptional.get();
            candidato.setNome(candidatoDetails.getNome());
            candidato.setEmail(candidatoDetails.getEmail());
            candidato.setTelefone(candidatoDetails.getTelefone());
            candidato.setEndereco(candidatoDetails.getEndereco());
            candidato.setDataNascimento(candidatoDetails.getDataNascimento());
            return ResponseEntity.ok(candidatoService.save(candidato));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidato(@PathVariable Long id) {
        if (candidatoService.findById(id).isPresent()) {
            candidatoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
