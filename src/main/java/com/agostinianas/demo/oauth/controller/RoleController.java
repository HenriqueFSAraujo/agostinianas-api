package com.agostinianas.demo.oauth.controller;

import java.util.List;

import com.agostinianas.demo.oauth.domain.dto.RoleDTO;
import com.agostinianas.demo.oauth.domain.entity.Role;
import com.agostinianas.demo.oauth.domain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

//    @GetMapping
//    public List<RoleDTO> getAllRoles() {
//        return roleService.getAllRoles();
//    }

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody RoleDTO role) {
        Role createdRole = roleService.createRole(role);
        return ResponseEntity.ok(createdRole);
    }
}
