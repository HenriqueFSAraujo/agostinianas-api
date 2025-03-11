package com.agostinianas.demo.oauth.domain.repository;


import com.agostinianas.demo.oauth.domain.entity.Role;
import com.agostinianas.demo.oauth.domain.enumerations.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(RoleEnum name);


}
