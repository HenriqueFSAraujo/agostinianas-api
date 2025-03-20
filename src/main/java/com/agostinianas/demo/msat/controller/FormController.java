package com.agostinianas.demo.msat.controller;

import com.agostinianas.demo.msat.Services.FormService;
import com.agostinianas.demo.msat.dto.FormDadosPessoaisDTO;
import com.agostinianas.demo.msat.entity.Form;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/forms")
@RequiredArgsConstructor
public class FormController {

    private final FormService formService;

//    @GetMapping
//    public ResponseEntity<List<FormDadosPessoaisDTO>> getAllForms() {
//        return ResponseEntity.ok(formService.getAllForms());
//    }

    @GetMapping("/form1/{id}")
    public ResponseEntity<Form> getFormById(@PathVariable Long id) {
        return ResponseEntity.ok(formService.getFormById(id));
    }

    @PostMapping
    public ResponseEntity<FormDadosPessoaisDTO> createForm(@RequestBody Form formDTO) {
        FormDadosPessoaisDTO savedForm = formService.createForm(formDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedForm);
    }
}
