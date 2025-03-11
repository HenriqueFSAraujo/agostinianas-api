package com.agostinianas.demo.oauth.domain.dto.request;



import com.agostinianas.demo.oauth.domain.enumerations.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleRequest {

    private Integer id;
    private RoleEnum name;
    private Boolean requiresTokenFirstLogin;
    private Boolean biometricValidation;
    private Boolean tokenLogin;

}
