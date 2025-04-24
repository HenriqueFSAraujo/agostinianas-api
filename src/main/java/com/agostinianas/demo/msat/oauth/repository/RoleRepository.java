package com.agostinianas.demo.msat.oauth.repository;

import com.agostinianas.demo.msat.oauth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
