package com.agostinianas.demo.msat.oauth.repository;

import com.agostinianas.demo.msat.oauth.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLoginRepository extends JpaRepository<UserInfo, Long> {
    public Optional<UserInfo> findByUserName(String user);

}
