package com.sriganeshsilktraders.invoice.invoiceGenerator.request;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String email;
    private  String password;
}
