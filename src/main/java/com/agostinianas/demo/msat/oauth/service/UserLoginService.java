package com.agostinianas.demo.msat.oauth.service;

import aj.org.objectweb.asm.commons.Remapper;
import com.agostinianas.demo.msat.oauth.dto.UserLoginRequest;
import com.agostinianas.demo.msat.oauth.dto.UserLoginResponse;
import com.agostinianas.demo.msat.oauth.entity.UserInfo;
import com.agostinianas.demo.msat.oauth.entity.UserLogin;
import com.agostinianas.demo.msat.oauth.mapper.UserLoginMapper;
import com.agostinianas.demo.msat.oauth.repository.UserInfoRepository;
import com.agostinianas.demo.msat.oauth.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLoginService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private UserLoginMapper userLoginMapper;

    public List<UserLoginResponse> getAll() {
        return userLoginRepository.findAll()
                .stream()
                .map(userLoginMapper::toDto)
                .toList();
    }

    public Optional<UserLoginResponse> getById(Long id) {
        return userLoginRepository.findById(id)
                .map(userLoginMapper::toDto);
    }

    public UserLoginResponse create(UserLoginRequest dto) {
        userInfoRepository.findByUserName(dto.getUserName())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + dto.getUserName()));

        UserLogin userLogin = userLoginMapper.toEntity(dto);
        UserLogin saved = userLoginRepository.save(userLogin);
        return userLoginMapper.toDto(saved);
    }
}

