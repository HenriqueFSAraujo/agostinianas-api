package com.agostinianas.demo.oauth.domain.service;


import com.agostinianas.demo.oauth.domain.entity.UserInfo;
import com.agostinianas.demo.oauth.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository IUserRepository;

    public UserDetailsServiceImpl(UserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



        UserInfo user = Optional.ofNullable(IUserRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Não foi possível encontrar o usuário com o nome de usuário:%s", username)));



        return new CustomUserDetails(user);
    }

}
