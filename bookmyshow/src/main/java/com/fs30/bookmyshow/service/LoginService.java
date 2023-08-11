package com.fs30.bookmyshow.service;

import com.fs30.bookmyshow.model.UserDetails;
import com.fs30.bookmyshow.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public String signUpUser(UserDetails userDetails) {
        return loginRepository.signUpUser(userDetails);
    }


    public String loginUser(UserDetails userDetails) {
        return loginRepository.loginUser(userDetails);
    }
}
