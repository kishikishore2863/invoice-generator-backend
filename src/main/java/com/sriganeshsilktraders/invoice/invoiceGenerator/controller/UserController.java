package com.sriganeshsilktraders.invoice.invoiceGenerator.controller;

import com.sriganeshsilktraders.invoice.invoiceGenerator.model.User;
import com.sriganeshsilktraders.invoice.invoiceGenerator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/get")
    public ResponseEntity<List<User>> getUsers(){
//        return (ResponseEntity<List<User>>) userRepository.findAll();
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "Hello from secured endpoint!";
    }

//    eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc1MDY2ODQyMiwiZXhwIjoxNzUwNjcyMDIyfQ.VrFHWHwC2tbHaCJ1gBQl3emmfvThtL04-P05HToUAac

}
