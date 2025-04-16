package com.agostinianas.demo.oauth.service;

import com.agostinianas.demo.msat.config.JwtUtil;
import com.agostinianas.demo.msat.dto.LoginRequestDTO;
import com.agostinianas.demo.msat.dto.LoginResponseDTO;
import com.agostinianas.demo.oauth.entity.UserInfo;
import com.agostinianas.demo.oauth.repository.UserLoginRepository;
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

    public LoginResponseDTO login(LoginRequestDTO request) {
        UserInfo user = userLoginRepository.findByUserName(request.getUser())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new BadCredentialsException("Senha inválida");
        }

        String token = jwtUtil.generateToken(user);


        user.setToken(token);
        userLoginRepository.save(user);

        return new LoginResponseDTO(user.getUserName(), token);
    }
}