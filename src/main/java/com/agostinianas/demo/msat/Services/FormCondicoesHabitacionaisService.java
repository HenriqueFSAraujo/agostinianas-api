package com.agostinianas.demo.msat.Services;

import com.agostinianas.demo.msat.dto.CondicoesHabitacionaisDTO;
import com.agostinianas.demo.msat.entity.FormCondicoesHabitacionais;
import com.agostinianas.demo.msat.repositories.FormCondicoesHabitacionaisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FormCondicoesHabitacionaisService {


    private FormCondicoesHabitacionaisRepository repository;


    public FormCondicoesHabitacionais create(CondicoesHabitacionaisDTO dto) {
        FormCondicoesHabitacionais entity = mapDtoToEntity(dto);
        return repository.save(entity);
    }


    public Optional<FormCondicoesHabitacionais> getById(Long id) {
        return repository.findById(id);
    }

    public List<FormCondicoesHabitacionais> getAll() {
        return repository.findAll();
    }

    public FormCondicoesHabitacionais update(Long id, CondicoesHabitacionaisDTO dto) {
        Optional<FormCondicoesHabitacionais> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            FormCondicoesHabitacionais entity = optionalEntity.get();
            entity.setSituacaoImovel(dto.getSituacaoImovel());
            entity.setTipoImovel(dto.getTipoImovel());
            entity.setEstruturaFisica(dto.getEstruturaFisica());
            entity.setEsgotoSanitario(dto.getEsgotoSanitario());
            entity.setFornecimentoEnergia(dto.getFornecimentoEnergia());
            entity.setAbastecimentoAgua(dto.getAbastecimentoAgua());
            return repository.save(entity);
        }
        return null;
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Método auxiliar para mapear DTO para Entity
    private FormCondicoesHabitacionais mapDtoToEntity(CondicoesHabitacionaisDTO dto) {
        FormCondicoesHabitacionais entity = new FormCondicoesHabitacionais();
        entity.setSituacaoImovel(dto.getSituacaoImovel());
        entity.setTipoImovel(dto.getTipoImovel());
        entity.setEstruturaFisica(dto.getEstruturaFisica());
        entity.setEsgotoSanitario(dto.getEsgotoSanitario());
        entity.setFornecimentoEnergia(dto.getFornecimentoEnergia());
        entity.setAbastecimentoAgua(dto.getAbastecimentoAgua());
        return entity;
    }
}
