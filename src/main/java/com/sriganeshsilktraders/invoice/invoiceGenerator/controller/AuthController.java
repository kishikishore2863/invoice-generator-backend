package com.sriganeshsilktraders.invoice.invoiceGenerator.controller;

import com.sriganeshsilktraders.invoice.invoiceGenerator.config.JWTUtil;
import com.sriganeshsilktraders.invoice.invoiceGenerator.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtil jwtUtil;

    @PostMapping("/api/auth/check")
    public String generateToken(@RequestBody LoginRequest loginRequest){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            return jwtUtil.generateToken(loginRequest.getEmail());
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }
    }

}
