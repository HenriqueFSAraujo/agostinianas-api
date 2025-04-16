package com.agostinianas.demo.msat.oauth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String user;
    private String token;

}
