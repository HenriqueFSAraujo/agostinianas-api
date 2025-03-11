package com.agostinianas.demo.oauth.domain.repository;


import com.agostinianas.demo.oauth.domain.entity.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserImageRepository extends JpaRepository<UserImage, Long> {

    Optional<UserImage> findByIdUser(Long userId);

}
