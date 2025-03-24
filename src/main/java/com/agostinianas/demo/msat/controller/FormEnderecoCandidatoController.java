package com.agostinianas.demo.msat.controller;

import com.agostinianas.demo.msat.dto.FormEnderecoCandidatoDTO;
import com.agostinianas.demo.msat.Services.FormEnderecoCandidatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
@RequiredArgsConstructor
public class FormEnderecoCandidatoController {

    private final FormEnderecoCandidatoService enderecoService;

    @PostMapping
    public ResponseEntity<FormEnderecoCandidatoDTO> criarEndereco(
            @Valid @RequestBody FormEnderecoCandidatoDTO enderecoDTO) {
        FormEnderecoCandidatoDTO novoEndereco = enderecoService.criarEndereco(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEndereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormEnderecoCandidatoDTO> atualizarEndereco(
            @PathVariable Long id,
            @Valid @RequestBody FormEnderecoCandidatoDTO enderecoDTO) {
        FormEnderecoCandidatoDTO enderecoAtualizado = enderecoService.atualizarEndereco(id, enderecoDTO);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormEnderecoCandidatoDTO> buscarPorId(@PathVariable Long id) {
        FormEnderecoCandidatoDTO endereco = enderecoService.buscarPorId(id);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping
    public ResponseEntity<List<FormEnderecoCandidatoDTO>> listarTodos() {
        List<FormEnderecoCandidatoDTO> enderecos = enderecoService.listarTodos();
        return ResponseEntity.ok(enderecos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/por-cep/{cep}")
    public ResponseEntity<List<FormEnderecoCandidatoDTO>> buscarPorCep(@PathVariable String cep) {
        List<FormEnderecoCandidatoDTO> enderecos = enderecoService.buscarPorCep(cep);
        return ResponseEntity.ok(enderecos);
    }


}

