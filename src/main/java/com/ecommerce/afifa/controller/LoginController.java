package com.ecommerce.afifa.controller;

import java.sql.SQLException;

import com.ecommerce.afifa.DTO.LoginRequest;
import com.ecommerce.afifa.services.LoginService;
import com.ecommerce.afifa.DTO.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest LoginBody) throws SQLException {

        return loginService.login(LoginBody);
    }
}
