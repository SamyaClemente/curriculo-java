package com.example.candidato.Controller;


import com.example.candidato.Service.ExperienciaProfissionalService;
import com.example.candidato.model.ExperienciaProfissional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/experienciasprofissionais")
public class ExperienciaProfissionalController {

    @Autowired
    private ExperienciaProfissionalService experienciaProfissionalService;

    @GetMapping
    public List<ExperienciaProfissional> getAllExperienciasProfissionais() {
        return experienciaProfissionalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaProfissional> getExperienciaProfissionalById(@PathVariable Long id) {
        Optional<ExperienciaProfissional> experienciaProfissional = experienciaProfissionalService.findById(id);
        return experienciaProfissional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ExperienciaProfissional createExperienciaProfissional(@RequestBody ExperienciaProfissional experienciaProfissional) {
        return experienciaProfissionalService.save(experienciaProfissional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienciaProfissional> updateExperienciaProfissional(@PathVariable Long id, @RequestBody ExperienciaProfissional experienciaProfissionalDetails) {
        Optional<ExperienciaProfissional> experienciaProfissionalOptional = experienciaProfissionalService.findById(id);
        if (experienciaProfissionalOptional.isPresent()) {
            ExperienciaProfissional experienciaProfissional = experienciaProfissionalOptional.get();
            experienciaProfissional.setCargo(experienciaProfissionalDetails.getCargo());
            experienciaProfissional.setEmpresa(experienciaProfissionalDetails.getEmpresa());
            experienciaProfissional.setDataInicio(experienciaProfissionalDetails.getDataInicio());
            experienciaProfissional.setDataFim(experienciaProfissionalDetails.getDataFim());
            experienciaProfissional.setDescricao(experienciaProfissionalDetails.getDescricao());
            return ResponseEntity.ok(experienciaProfissionalService.save(experienciaProfissional));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperienciaProfissional(@PathVariable Long id) {
        if (experienciaProfissionalService.findById(id).isPresent()) {
            experienciaProfissionalService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
