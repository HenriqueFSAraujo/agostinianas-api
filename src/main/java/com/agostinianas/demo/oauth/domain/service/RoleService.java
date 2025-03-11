package com.agostinianas.demo.oauth.domain.service;

import com.agostinianas.demo.core.domain.exception.NegocioException;
import com.agostinianas.demo.oauth.domain.dto.RoleDTO;
import com.agostinianas.demo.oauth.domain.entity.Role;
import com.agostinianas.demo.oauth.domain.mapper.RoleMapper;
import com.agostinianas.demo.oauth.domain.repository.RoleRepository;




import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleMapper roleMapper;
    private final RoleRepository roleRepository;

    public Role createRole(RoleDTO roleDTO) {

        roleRepository.findByName(roleDTO.getName())
                .orElseThrow(() -> new NegocioException(String.format("Role %s Já existe", roleDTO.getName())));

        var role = RoleMapper.toEntity(roleDTO);

        return roleRepository.save(role);
    }

//    public List<RoleDTO> getAllRoles() {
//        List<Role> roles = roleRepository.findAll();
//        return RoleMapper.toEntity(roles);
//    }

}