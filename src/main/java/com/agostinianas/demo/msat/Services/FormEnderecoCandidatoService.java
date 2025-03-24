package com.agostinianas.demo.msat.Services;

import com.agostinianas.demo.msat.dto.FormEnderecoCandidatoDTO;
import com.agostinianas.demo.msat.entity.FormEnderecoCandidato;
import com.agostinianas.demo.msat.mapper.FormEnderecoCandidatoMapper;
import com.agostinianas.demo.msat.repositories.FormEnderecoCandidatoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FormEnderecoCandidatoService {

    private final FormEnderecoCandidatoRepository enderecoRepository;
    private final FormEnderecoCandidatoMapper enderecoMapper;

    /**
     * Cria um novo endereço
     */
    public FormEnderecoCandidatoDTO criarEndereco(FormEnderecoCandidatoDTO enderecoDTO) {
        //validarEndereco(enderecoDTO);

        FormEnderecoCandidato endereco = enderecoMapper.toEntity(enderecoDTO);
        endereco.setId(null); // Garante que será um novo registro

        FormEnderecoCandidato enderecoSalvo = enderecoRepository.save(endereco);
        return enderecoMapper.toDto(enderecoSalvo);
    }

    public FormEnderecoCandidatoDTO atualizarEndereco(Long id, FormEnderecoCandidatoDTO enderecoDTO) {
        //validarEndereco(enderecoDTO);

        FormEnderecoCandidato enderecoExistente = enderecoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado com ID: " + id));

        // Atualiza apenas os campos permitidos
        enderecoExistente.setCep(enderecoDTO.getCep());
        enderecoExistente.setEndereco(enderecoDTO.getEndereco());
        enderecoExistente.setBairro(enderecoDTO.getBairro());
        enderecoExistente.setCidade(enderecoDTO.getCidade());
        enderecoExistente.setPontoReferencia(enderecoDTO.getPontoReferencia());
        enderecoExistente.setResidencia(enderecoDTO.getResidencia());
        enderecoExistente.setTransporteEducacional(enderecoDTO.getTransporteEducacional());
        enderecoExistente.setTempoDeslocamento(enderecoDTO.getTempoDeslocamento());
        enderecoExistente.setAtividadesContraturno(enderecoDTO.getAtividadesContraturno());
        enderecoExistente.setTelefoneResidencial(enderecoDTO.getTelefoneResidencial());
        enderecoExistente.setTelefoneTrabalho(enderecoDTO.getTelefoneTrabalho());
        enderecoExistente.setTelefoneCelular(enderecoDTO.getTelefoneCelular());
        enderecoExistente.setEmailConfirmacao(enderecoDTO.getEmailConfirmacao());
        enderecoExistente.setResponsavelLegal(enderecoDTO.getResponsavelLegal());
        enderecoExistente.setSegmento2025(enderecoDTO.getSegmento2025());

        FormEnderecoCandidato enderecoAtualizado = enderecoRepository.save(enderecoExistente);
        return enderecoMapper.toDto(enderecoAtualizado);
    }

    /**
     * Busca endereço por ID
     */
    public FormEnderecoCandidatoDTO buscarPorId(Long id) {
        FormEnderecoCandidato endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado com ID: " + id));

        return enderecoMapper.toDto(endereco);
    }

    /**
     * Lista todos os endereços
     */
    public List<FormEnderecoCandidatoDTO> listarTodos() {
        return enderecoRepository.findAll()
                .stream()
                .map(enderecoMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Deleta um endereço
     */
    public void deletarEndereco(Long id) {
        if (!enderecoRepository.existsById(id)) {
            throw new EntityNotFoundException("Endereço não encontrado com ID: " + id);
        }
        enderecoRepository.deleteById(id);
    }

    /**
     * Busca endereços por CEP
     */
    public List<FormEnderecoCandidatoDTO> buscarPorCep(String cep) {
        return enderecoRepository.findByCep(cep)
                .stream()
                .map(enderecoMapper::toDto)
                .collect(Collectors.toList());
    }


    private void validarEndereco(FormEnderecoCandidatoDTO enderecoDTO) {
        if (enderecoDTO.getCep() == null || enderecoDTO.getCep().isBlank()) {
            throw new IllegalArgumentException("CEP é obrigatório");
        }

        if (enderecoDTO.getEndereco() == null || enderecoDTO.getEndereco().isBlank()) {
            throw new IllegalArgumentException("Endereço é obrigatório");
        }

        if (enderecoDTO.getCidade() == null || enderecoDTO.getCidade().isBlank()) {
            throw new IllegalArgumentException("Cidade é obrigatória");
        }

        // Validação do formato do CEP (opcional)
        if (!enderecoDTO.getCep().matches("\\d{5}-?\\d{3}")) {
            throw new IllegalArgumentException("CEP deve estar no formato 00000-000");
        }
}
}
