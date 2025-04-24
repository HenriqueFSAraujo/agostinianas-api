package com.agostinianas.demo.msat.oauth.mapper;

import com.agostinianas.demo.msat.oauth.RoleEnum;
import com.agostinianas.demo.msat.oauth.dto.UserLoginRequest;
import com.agostinianas.demo.msat.oauth.dto.UserLoginResponse;
import com.agostinianas.demo.msat.oauth.entity.Role;
import com.agostinianas.demo.msat.oauth.entity.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserLoginMapper {

    public UserInfo toEntity(UserLoginRequest dto) {
        if (dto == null) {
            return null;
        }

        UserInfo userLogin = new UserInfo();
        userLogin.setUserName(dto.getUserName());
        userLogin.setPassword(dto.getPassword());
        return userLogin;
    }

    public UserLoginResponse toDto(UserInfo entity) {
        if (entity == null) {
            return null;
        }

        RoleEnum roleName = (entity.getRole() != null)
                ? entity.getRole().getName()
                : null;

        return new UserLoginResponse(
                entity.getUserName(),
                roleName,
                entity
        );
    }
}
