package com.ecommerce.ecommerceapi_.controller;

import com.ecommerce.ecommerceapi_.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/login")
    public User login(){
        return new User(123,"manupathak","manupathak@gmail.com");
    }
}

//http://localhost:8080/login