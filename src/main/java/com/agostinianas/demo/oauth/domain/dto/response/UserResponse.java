package com.agostinianas.demo.oauth.domain.dto.response;

import java.sql.Timestamp;
import java.util.Set;

import com.agostinianas.demo.oauth.domain.dto.RoleDTO;
import com.agostinianas.demo.oauth.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponse {

    private Long id;
    private String username;
    private String fullName;
    private String email;
    private boolean isEnabled;
    private String link;
    private boolean isReset;
    private Timestamp resetAt;
    private Set<Role> roles;
    private boolean isCreatedByAdmin;
    private boolean isPasswordChangedByUser;
    private String companyId;
    private String phone;
    private String cpf;

}
