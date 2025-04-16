package com.agostinianas.demo.oauth.repository;

import com.agostinianas.demo.oauth.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLoginRepository extends JpaRepository<UserInfo, Long> {
    public Optional<UserInfo> findByUserName(String user);

    UserInfo update(Long id, UserInfo userLogin);
}
