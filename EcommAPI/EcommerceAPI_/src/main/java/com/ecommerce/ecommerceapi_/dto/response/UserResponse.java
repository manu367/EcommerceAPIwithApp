package com.ecommerce.ecommerceapi_.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class UserResponse {
        private Long id;
        private String name;
        private String email;
        private String phone;
        private String password;
    }
