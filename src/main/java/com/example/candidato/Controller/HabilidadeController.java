package com.example.candidato.Controller;


import com.example.candidato.Service.HabilidadeService;
import com.example.candidato.model.Habilidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadeController {

    @Autowired
    private HabilidadeService habilidadeService;

    @GetMapping
    public List<Habilidade> getAllHabilidades() {
        return habilidadeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidade> getHabilidadeById(@PathVariable Long id) {
        Optional<Habilidade> habilidade = habilidadeService.findById(id);
        return habilidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Habilidade createHabilidade(@RequestBody Habilidade habilidade) {
        return habilidadeService.save(habilidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habilidade> updateHabilidade(@PathVariable Long id, @RequestBody Habilidade habilidadeDetails) {
        Optional<Habilidade> habilidadeOptional = habilidadeService.findById(id);
        if (habilidadeOptional.isPresent()) {
            Habilidade habilidade = habilidadeOptional.get();
            habilidade.setHabilidade(habilidadeDetails.getHabilidade());
            return ResponseEntity.ok(habilidadeService.save(habilidade));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabilidade(@PathVariable Long id) {
        if (habilidadeService.findById(id).isPresent()) {
            habilidadeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
