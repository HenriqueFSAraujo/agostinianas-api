package com.agostinianas.demo.oauth.domain.repository;


import com.agostinianas.demo.oauth.domain.entity.RefreshToken;
import com.agostinianas.demo.oauth.domain.repository.infrastructure.CustomJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRefreshTokenRepository extends CustomJpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

}
