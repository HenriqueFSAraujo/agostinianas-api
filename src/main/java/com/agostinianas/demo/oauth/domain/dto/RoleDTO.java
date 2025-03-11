package com.agostinianas.demo.oauth.domain.dto;

import com.agostinianas.demo.oauth.domain.enumerations.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Integer id;
    private RoleEnum name;
    private Boolean requiresTokenFirstLogin;
    private Boolean biometricValidation;
    private Boolean tokenLogin;

}