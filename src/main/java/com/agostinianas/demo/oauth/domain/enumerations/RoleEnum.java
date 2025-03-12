package com.agostinianas.demo.oauth.domain.enumerations;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter

public enum RoleEnum {

    ROLE_USER("ROLE_USER", "ROLE_USER"),
    ROLE_MODERATOR("ROLE_MODERATOR", "ROLE_MODERATOR"),
    ROLE_ADMIN("ROLE_ADMIN", "ROLE_ADIMIN"),
    ROLE_ESCOBS("ROLE_ESCOBS", "ROLE_ESCOBS"),
    ROLE_AGENTE_OFICIAL("ROLE_AGENTE_OFICIAL", "ROLE_AGENTE_OFICIAL"),
    ROLE_LOCALIZADOR("ROLE_LOCALIZADOR", "ROLE_LOCALIZADOR"),
    ROLE_GUINCHO("ROLE_GUINCHO", "ROLE_GUINCHO"),
    ROLE_PATIO("ROLE_PATIO", "ROLE_PATIO"),
    ROLE_DETRAN("ROLE_DETRAN", "ROLE_DETRAN");

    private final String code;
    private final String description;

    RoleEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }


}

