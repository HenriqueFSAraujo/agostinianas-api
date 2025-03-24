package com.agostinianas.demo.msat.controller;


import com.agostinianas.demo.msat.Services.FormDadosParentesService;
import com.agostinianas.demo.msat.dto.FormDadosParentesDTO;
import com.agostinianas.demo.msat.entity.FormDadosParentes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parentes")
@RequiredArgsConstructor
public class FormDadosParentesController {

    private final FormDadosParentesService service;



    @GetMapping("/{id}")
    public ResponseEntity<FormDadosParentesDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<FormDadosParentesDTO> create(@RequestBody FormDadosParentesDTO createDTO) {
        return ResponseEntity.ok(service.create(createDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormDadosParentesDTO> update(@PathVariable Long id, @RequestBody FormDadosParentesDTO updateDTO) {
        return ResponseEntity.ok(service.update(id, updateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
