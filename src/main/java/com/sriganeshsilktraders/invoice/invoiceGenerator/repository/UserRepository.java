package com.sriganeshsilktraders.invoice.invoiceGenerator.repository;

import com.sriganeshsilktraders.invoice.invoiceGenerator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
//    User findByUserName(String userName);
}
