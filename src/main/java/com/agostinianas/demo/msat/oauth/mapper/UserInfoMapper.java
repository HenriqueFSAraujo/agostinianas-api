package com.agostinianas.demo.msat.oauth.mapper;

import com.agostinianas.demo.msat.oauth.dto.UserInfoDTO;
import com.agostinianas.demo.msat.oauth.entity.UserInfo;
import com.agostinianas.demo.msat.oauth.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class UserInfoMapper {

    private final RoleRepository roleRepository;

    public UserInfoMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UserInfo toEntity(UserInfoDTO dto) {
        UserInfo entity = new UserInfo();
        entity.setName(dto.getName());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setToken(dto.getToken());
        entity.setFirstLogin(dto.isFirstLogin());


        return entity;
    }

    public UserInfoDTO toDTO(UserInfo entity) {
        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUserName(entity.getUserName());
        dto.setToken(entity.getToken());
        dto.setIsFirstLogin(entity.isFirstLogin());
        dto.setRoleName(entity.getRole() != null ? entity.getRole().getName().name() : null);

        return dto;
    }
}