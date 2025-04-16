package com.agostinianas.demo.oauth.controller;

import com.agostinianas.demo.oauth.entity.UserInfo;
import com.agostinianas.demo.oauth.repository.UserLoginRepository;
import com.agostinianas.demo.oauth.service.UserLoginService;
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
    @Autowired
    private UserLoginRepository userLoginRepository;



    @GetMapping
    public ResponseEntity<List<UserInfo>> getAll() {
        return ResponseEntity.ok(userLoginService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> getById(@PathVariable Long id) {
        return userLoginRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserInfo> create(@RequestBody UserInfo userLogin) {
        return ResponseEntity.ok(userLoginRepository.save(userLogin));
    }
    //
    //    @PutMapping("/{id}")
    //    public ResponseEntity<UserLogin> update(@PathVariable Long id, @RequestBody UserLogin userLogin) {
    //        UserLogin updated = userLoginRepository.update(id, userLogin);
    //        if (updated != null) {
    //            return ResponseEntity.ok(updated);
    //        } else {
    //            return ResponseEntity.notFound().build();
    //        }
    //    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        if (userLoginRepository.deleteById()){
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
