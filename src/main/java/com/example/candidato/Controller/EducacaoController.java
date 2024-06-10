package com.example.candidato.Controller;


import com.example.candidato.Service.EducacaoService;
import com.example.candidato.model.Educacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/educacoes")
public class EducacaoController {

    @Autowired
    private EducacaoService educacaoService;

    @GetMapping
    public List<Educacao> getAllEducacoes() {
        return educacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Educacao> getEducacaoById(@PathVariable Long id) {
        Optional<Educacao> educacao = educacaoService.findById(id);
        return educacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Educacao createEducacao(@RequestBody Educacao educacao) {
        return educacaoService.save(educacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Educacao> updateEducacao(@PathVariable Long id, @RequestBody Educacao educacaoDetails) {
        Optional<Educacao> educacaoOptional = educacaoService.findById(id);
        if (educacaoOptional.isPresent()) {
            Educacao educacao = educacaoOptional.get();
            educacao.setInstituicao(educacaoDetails.getInstituicao());
            educacao.setCurso(educacaoDetails.getCurso());
            educacao.setNivelEducacional(educacaoDetails.getNivelEducacional());
            educacao.setDataInicio(educacaoDetails.getDataInicio());
            educacao.setDataConclusao(educacaoDetails.getDataConclusao());
            educacao.setDescricao(educacaoDetails.getDescricao());
            return ResponseEntity.ok(educacaoService.save(educacao));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducacao(@PathVariable Long id) {
        if (educacaoService.findById(id).isPresent()) {
            educacaoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
