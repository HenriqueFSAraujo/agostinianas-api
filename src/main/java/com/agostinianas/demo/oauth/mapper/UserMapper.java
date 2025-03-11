package com.agostinianas.demo.oauth.mapper;


import com.agostinianas.demo.oauth.domain.dto.request.UserRequest;
import com.agostinianas.demo.oauth.domain.dto.response.UserResponse;
import com.agostinianas.demo.oauth.domain.entity.UserInfo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class UserMapper {

    private UserMapper() {
    }

    public static UserInfo toEntity(UserRequest userRequest) {
        if (userRequest == null) {
            return null;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userRequest.getId());
        userInfo.setUsername(userRequest.getUsername());
        userInfo.setFullName(userRequest.getFullName());
        userInfo.setEmail(userRequest.getEmail());
        userInfo.setPassword(userRequest.getPassword());
        userInfo.setRoles(userRequest.getRoles());
        return userInfo;
    }

    public static UserResponse toResponse(UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userInfo.getId());
        userResponse.setUsername(userInfo.getUsername());
        userResponse.setFullName(userInfo.getFullName());
        userResponse.setEmail(userInfo.getEmail());
        userResponse.setRoles(userInfo.getRoles());
        return userResponse;
    }

    public static List<UserResponse> toResponseList(List<UserInfo> users) {
        if (users == null) {
            return Collections.emptyList();
        }
        return users.stream().map(UserMapper::toResponse).collect(Collectors.toList());
    }

    public static List<UserInfo> toEntityList(List<UserRequest> userRequests) {
        if (userRequests == null) {
            return Collections.emptyList();
        }
        return userRequests.stream().map(UserMapper::toEntity).collect(Collectors.toList());
    }
}

