package com.agostinianas.demo.msat.controller;

import com.agostinianas.demo.msat.Services.FormService;
import com.agostinianas.demo.msat.dto.FormDadosPessoaisDTO;

import com.agostinianas.demo.msat.entity.FormDadosPessoais;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/forms")
@RequiredArgsConstructor
public class FormController {

    private final FormService formService;


    @GetMapping("/form1/{id}")
    public ResponseEntity<FormDadosPessoais> getFormById(@PathVariable Long id) {
        return ResponseEntity.ok(formService.getFormById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormDadosPessoaisDTO> createForm(@RequestBody FormDadosPessoaisDTO formDTO) {
        FormDadosPessoaisDTO savedForm = formService.createDadosPessoais(formDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedForm);
    }
}
