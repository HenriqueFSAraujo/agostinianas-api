package com.agostinianas.demo.msat.Services;

import com.agostinianas.demo.msat.dto.FormDadosPessoaisDTO;
import com.agostinianas.demo.msat.dto.FormEnderecoCandidatoDTO;
import com.agostinianas.demo.msat.entity.FormDadosPessoais;
import com.agostinianas.demo.msat.entity.FormEnderecoCandidato;
import com.agostinianas.demo.msat.mapper.FormDadosPessoaisMapper;
import com.agostinianas.demo.msat.mapper.FormEnderecoCandidatoMapper;
import com.agostinianas.demo.msat.repositories.FormEnderecoCandidatoRepository;
import com.agostinianas.demo.msat.repositories.FormRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormService {



        private final FormRepository dadosPessoaisRepository;
        private final FormEnderecoCandidatoRepository enderecoRepository;
        private final FormDadosPessoaisMapper dadosPessoaisMapper;
        private final FormEnderecoCandidatoMapper enderecoMapper;

        public FormDadosPessoaisDTO createDadosPessoais(FormDadosPessoaisDTO dto) {
            FormDadosPessoais entity = dadosPessoaisMapper.toEntity(dto);
            entity.setId(null);
            FormDadosPessoais saved = dadosPessoaisRepository.save(entity);
            return dadosPessoaisMapper.toDto(saved);
        }

    public FormDadosPessoais getFormById(Long id) {
        return dadosPessoaisRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formulário de dados dos pais não encontrado com ID: " + id));
    }

        public FormDadosPessoaisDTO updateDadosPessoais(Long id, FormDadosPessoaisDTO dto) {
            FormDadosPessoais existing = dadosPessoaisRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Dados pessoais não encontrados"));

            existing.setFullName(dto.getFullName());
            existing.setLogin(dto.getLogin());

            FormDadosPessoais updated = dadosPessoaisRepository.save(existing);
            return dadosPessoaisMapper.toDto(updated);
        }



    }

