package com.agostinianas.demo.msat.oauth.repository;

import com.agostinianas.demo.msat.oauth.entity.UserInfo;
import com.agostinianas.demo.msat.oauth.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    public Optional<UserLogin> findByUserName(String user);

    UserLogin update(Long id, UserInfo userLogin);
}
