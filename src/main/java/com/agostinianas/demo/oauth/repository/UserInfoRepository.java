package com.agostinianas.demo.oauth.repository;

import com.agostinianas.demo.oauth.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository  extends JpaRepository<UserInfo, Long> {
       public Optional< UserInfo> findByUserName(String userName);
}
