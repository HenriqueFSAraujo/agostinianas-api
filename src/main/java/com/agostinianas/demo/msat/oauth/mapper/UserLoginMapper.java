package com.agostinianas.demo.msat.oauth.mapper;

import com.agostinianas.demo.msat.oauth.dto.UserLoginRequest;
import com.agostinianas.demo.msat.oauth.dto.UserLoginResponse;
import com.agostinianas.demo.msat.oauth.entity.UserLogin;
import org.springframework.stereotype.Component;

@Component
public class UserLoginMapper {

    public UserLogin toEntity(UserLoginRequest dto) {
        UserLogin entity = new UserLogin();
        entity.setName(dto.getName());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setPhoto(dto.getPhoto());
        entity.setToken(dto.getToken());
        return entity;
    }

    public UserLoginResponse toDto(UserLogin entity) {
        UserLoginResponse dto = new UserLoginResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUserName(entity.getUserName());
        dto.setPhoto(entity.getPhoto());
        return dto;
    }
}
