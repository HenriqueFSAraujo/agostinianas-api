package com.agostinianas.demo.msat.Services;

import com.agostinianas.demo.msat.dto.FormDadosParentesDTO;
import com.agostinianas.demo.msat.entity.FormDadosParentes;
import com.agostinianas.demo.msat.repositories.FormDadosParentesRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FormDadosParentesService {

    private final FormDadosParentesRepository repository;
    private final ModelMapper modelMapper;

    // Buscar todos os registros
    public List<FormDadosParentesDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(parent -> modelMapper.map(parent, FormDadosParentesDTO.class))
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public FormDadosParentesDTO getById(Long id) {
        FormDadosParentes parent = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Registro não encontrado com ID: " + id));
        return modelMapper.map(parent, FormDadosParentesDTO.class);
    }

    // Criar novo registro
    public FormDadosParentesDTO create(FormDadosParentesDTO createDTO) {
        FormDadosParentes entity = modelMapper.map(createDTO, FormDadosParentes.class);
        FormDadosParentes savedEntity = repository.save(entity);
        return modelMapper.map(savedEntity, FormDadosParentesDTO.class);
    }

    // Atualizar registro existente
    public FormDadosParentesDTO update(Long id, FormDadosParentesDTO updateDTO) {
        FormDadosParentes existente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Registro não encontrado com ID: " + id));

        modelMapper.map(updateDTO, existente);
        FormDadosParentes updatedEntity = repository.save(existente);

        return modelMapper.map(updatedEntity, FormDadosParentesDTO.class);
    }

    // Deletar registro por ID
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Registro não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
}
