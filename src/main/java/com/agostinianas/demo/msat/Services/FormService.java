package com.agostinianas.demo.msat.Services;

import com.agostinianas.demo.msat.dto.FormDadosPessoaisDTO;
import com.agostinianas.demo.msat.entity.Form;
import com.agostinianas.demo.msat.repositories.FormRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FormService {

    private final FormRepository formRepository;
    private final ModelMapper modelMapper;


    // METODOS PARA FORMULARIO DE DADOS PESSOAIS
    public List<FormDadosPessoaisDTO> getAllForms() {
        return formRepository.findAll().stream()
                .map(form -> modelMapper.map(form, FormDadosPessoaisDTO.class))
                .collect(Collectors.toList());
    }

    public Form getFormById(Long id) {
        Form form = formRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formulário não encontrado com ID: " + id));
        return modelMapper.map(form, Form.class);
    }

    public FormDadosPessoaisDTO createForm(Form formDTO) {
        Form form = modelMapper.map(formDTO, Form.class);
        Form savedForm = formRepository.save(form);
        return modelMapper.map(savedForm, FormDadosPessoaisDTO.class);
    }


    // METODOS PARA FORMULARIO DE
}
