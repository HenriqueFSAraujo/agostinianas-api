package com.agostinianas.demo.msat.mapper;

import com.agostinianas.demo.msat.dto.FormEnderecoCandidatoDTO;
import com.agostinianas.demo.msat.entity.FormEnderecoCandidato;
import org.springframework.stereotype.Component;

@Component
public class FormEnderecoCandidatoMapper {

    public FormEnderecoCandidato toEntity(FormEnderecoCandidatoDTO dto) {
        if (dto == null) {
            return null;
        }

        FormEnderecoCandidato entity = new FormEnderecoCandidato();
        entity.setId(dto.getId());
        entity.setCep(dto.getCep());
        entity.setEndereco(dto.getEndereco());
        entity.setBairro(dto.getBairro());
        entity.setCidade(dto.getCidade());
        entity.setPontoReferencia(dto.getPontoReferencia());
        entity.setResidencia(dto.getResidencia());
        entity.setTransporteEducacional(dto.getTransporteEducacional());
        entity.setTempoDeslocamento(dto.getTempoDeslocamento());
        entity.setAtividadesContraturno(dto.getAtividadesContraturno());
        entity.setTelefoneResidencial(dto.getTelefoneResidencial());
        entity.setTelefoneTrabalho(dto.getTelefoneTrabalho());
        entity.setTelefoneCelular(dto.getTelefoneCelular());
        entity.setEmailConfirmacao(dto.getEmailConfirmacao());
        entity.setResponsavelLegal(dto.getResponsavelLegal());
        entity.setSegmento2025(dto.getSegmento2025());

        return entity;
    }

    public FormEnderecoCandidatoDTO toDto(FormEnderecoCandidato entity) {
        if (entity == null) {
            return null;
        }

        FormEnderecoCandidatoDTO dto = new FormEnderecoCandidatoDTO();
        dto.setId(entity.getId());
        dto.setCep(entity.getCep());
        dto.setEndereco(entity.getEndereco());
        dto.setBairro(entity.getBairro());
        dto.setCidade(entity.getCidade());
        dto.setPontoReferencia(entity.getPontoReferencia());
        dto.setResidencia(entity.getResidencia());
        dto.setTransporteEducacional(entity.getTransporteEducacional());
        dto.setTempoDeslocamento(entity.getTempoDeslocamento());
        dto.setAtividadesContraturno(entity.getAtividadesContraturno());
        dto.setTelefoneResidencial(entity.getTelefoneResidencial());
        dto.setTelefoneTrabalho(entity.getTelefoneTrabalho());
        dto.setTelefoneCelular(entity.getTelefoneCelular());
        dto.setEmailConfirmacao(entity.getEmailConfirmacao());
        dto.setResponsavelLegal(entity.getResponsavelLegal());
        dto.setSegmento2025(entity.getSegmento2025());

        return dto;
    }
}