package com.agostinianas.demo.msat.oauth.dto;

import com.agostinianas.demo.msat.oauth.RoleEnum;
import com.agostinianas.demo.msat.oauth.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginResponse {


    private String userName;
    private RoleEnum role;

    private UserInfo userInfo ;

}
