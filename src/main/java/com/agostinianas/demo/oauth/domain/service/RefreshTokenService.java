package com.agostinianas.demo.oauth.domain.service;

import com.agostinianas.demo.oauth.domain.entity.RefreshToken;
import com.agostinianas.demo.oauth.domain.repository.UserRepository;
import com.agostinianas.demo.oauth.domain.repository.impl.RefreshTokenRepository;

import com.montreal.oauth.domain.exception.RefreshTokenException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    public RefreshToken createRefreshToken(String username){
        RefreshToken refreshToken = RefreshToken.builder()
                .userInfo(userRepository.findByUsername(username))
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plus(1, ChronoUnit.HOURS))
                .build();
        return refreshTokenRepository.getIRefreshTokenRepository().save(refreshToken);
    }

    public String getTokenByUserId(Long userId){
        return refreshTokenRepository.getTokenByUserId(userId);
    }

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.getIRefreshTokenRepository().findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().compareTo(Instant.now())<0){
            refreshTokenRepository.getIRefreshTokenRepository().delete(token);
            throw new RefreshTokenException(token.getToken() + " Refresh token is expired. Please make a new login..!");
        }
        return token;
    }


}
