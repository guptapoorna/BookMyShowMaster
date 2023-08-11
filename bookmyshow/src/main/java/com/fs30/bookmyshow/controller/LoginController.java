package com.fs30.bookmyshow.controller;

import com.fs30.bookmyshow.model.UserDetails;
import com.fs30.bookmyshow.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/")
@RestController
public class LoginController{
    @Autowired
    private LoginService loginService;

    @PostMapping("signup")
    public String signUpUser(@RequestBody UserDetails userDetails) {
        return loginService.signUpUser(userDetails);
    }

    @PostMapping("login")
    public String loginUser(@RequestBody UserDetails userDetails) {
        return loginService.loginUser(userDetails);
    }


}
