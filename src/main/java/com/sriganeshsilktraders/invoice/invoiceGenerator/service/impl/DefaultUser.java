package com.sriganeshsilktraders.invoice.invoiceGenerator.service.impl;

import com.sriganeshsilktraders.invoice.invoiceGenerator.model.User;
import com.sriganeshsilktraders.invoice.invoiceGenerator.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultUser {

    @Bean
    public CommandLineRunner createAdminUser(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {
            if (userRepository.findByEmail("admin") == null) {
                User admin = new User();
                admin.setEmail("admin");
                admin.setPassword(passwordEncoder.encode("admin"));
                userRepository.save(admin);
                System.out.println("Default admin created");
            }
        };
    }
}
