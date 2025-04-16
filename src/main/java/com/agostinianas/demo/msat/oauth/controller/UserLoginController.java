package com.agostinianas.demo.msat.oauth.controller;

import com.agostinianas.demo.msat.oauth.dto.UserLoginRequest;
import com.agostinianas.demo.msat.oauth.dto.UserLoginResponse;
import com.agostinianas.demo.msat.oauth.entity.UserLogin;
import com.agostinianas.demo.msat.oauth.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-logins")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping
    public ResponseEntity<List<UserLoginResponse>> getAll() {
        return ResponseEntity.ok(userLoginService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserLoginResponse> getById(@PathVariable Long id) {
        return userLoginService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserLoginResponse> create(@RequestBody UserLoginRequest dto) {
        return ResponseEntity.ok(userLoginService.create(dto));
    }
}