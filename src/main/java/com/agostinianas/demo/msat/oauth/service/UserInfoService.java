package com.agostinianas.demo.msat.oauth.service;

import com.agostinianas.demo.msat.oauth.dto.UserInfoDTO;
import com.agostinianas.demo.msat.oauth.entity.UserInfo;
import com.agostinianas.demo.msat.oauth.mapper.UserInfoMapper;
import com.agostinianas.demo.msat.oauth.repository.UserInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserInfoService {

    private final UserInfoRepository repository;
    private final UserInfoMapper mapper;

    public UserInfoService(UserInfoRepository repository, UserInfoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UserInfoDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserInfoDTO findById(Long id) {
        UserInfo entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        return mapper.toDTO(entity);
    }

    public UserInfoDTO create(UserInfoDTO dto) {
        UserInfo entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    public UserInfoDTO update(Long id, UserInfoDTO dto) {
        UserInfo entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        entity.setName(dto.getName());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setToken(dto.getToken());
        entity.setFirstLogin(dto.isFirstLogin());


        return mapper.toDTO(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
}
