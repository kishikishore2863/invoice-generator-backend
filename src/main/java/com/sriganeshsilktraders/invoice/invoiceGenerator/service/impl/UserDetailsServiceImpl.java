package com.sriganeshsilktraders.invoice.invoiceGenerator.service.impl;

import com.sriganeshsilktraders.invoice.invoiceGenerator.model.User;
import com.sriganeshsilktraders.invoice.invoiceGenerator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email);
//
//        if(user==null)throw new UsernameNotFoundException("email not found");
//
//
//        UserBuilder builder = withUsername(user.getEmail());
//        builder.password(user.getPassword());
//        builder.roles(user.getRole()); // assumes role is a simple String like "ADMIN"
//
//        return builder.build();
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
         return userRepository.findByEmail(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user not found in userDetails");
        }
    }
}
