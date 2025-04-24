package com.agostinianas.demo.msat.oauth.service;

import com.agostinianas.demo.msat.config.JwtUtil;
import com.agostinianas.demo.msat.oauth.dto.UserLoginRequest;
import com.agostinianas.demo.msat.oauth.dto.UserLoginResponse;

import com.agostinianas.demo.msat.oauth.entity.UserInfo;

import com.agostinianas.demo.msat.oauth.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public UserLoginResponse login(UserLoginRequest request) {
        UserInfo user = userLoginRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new BadCredentialsException("Senha inválida");
        }

        String token = jwtUtil.generateToken(user);

        user.setToken(token);
        userLoginRepository.save(user);

        return new UserLoginResponse(user.getUserName(), user.getRole().getName(),user);
    }
}