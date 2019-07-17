package com.tdc.service;

import com.tdc.domain.User;
import com.tdc.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepo loginRepo;

    @Override
    public boolean login(String username, String password) {
        Optional<User>  u1=loginRepo.findUserByUsername(username);
        boolean logged=false;
        if(u1.isPresent()){
             logged=new BCryptPasswordEncoder().matches(password,u1.get().getPassword());

        }
        return logged;
    }
}
