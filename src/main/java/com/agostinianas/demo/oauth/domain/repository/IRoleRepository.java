package com.agostinianas.demo.oauth.domain.repository;


import com.agostinianas.demo.oauth.domain.entity.Role;
import com.agostinianas.demo.oauth.domain.enumerations.RoleEnum;
import com.agostinianas.demo.oauth.domain.repository.infrastructure.CustomJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends CustomJpaRepository<Role, Long> {

    Optional<Role> findByName(RoleEnum name);

}
