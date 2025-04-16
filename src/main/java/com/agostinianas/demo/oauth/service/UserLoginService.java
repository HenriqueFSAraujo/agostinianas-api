package com.agostinianas.demo.oauth.service;

import com.agostinianas.demo.oauth.entity.UserInfo;
import com.agostinianas.demo.oauth.repository.UserInfoRepository;
import com.agostinianas.demo.oauth.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginService {

    @Autowired
    private UserInfoRepository usersRepository;

    @Autowired
    private UserLoginRepository userLoginRepository;

    public void createUserLogin(String userName, String name, String password, String photo, String token, String role) {
        UserInfo user = usersRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        UserInfo login = new UserInfo();
        login.setName(name);
        login.setUserName(userName);
        login.setPassword(password);
        login.setPhoto(photo);
        login.setToken(token);
        userLoginRepository.save(login);
    }

    public List<UserInfo> getAll() {
        return userLoginRepository.findAll();
    }
}

