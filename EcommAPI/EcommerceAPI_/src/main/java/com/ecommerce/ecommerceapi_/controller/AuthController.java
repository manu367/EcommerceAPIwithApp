package com.ecommerce.ecommerceapi_.controller;

import com.ecommerce.ecommerceapi_.dto.LoginDto;
import com.ecommerce.ecommerceapi_.dto.response.UserResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class AuthController {

    @GetMapping("/login")
    public UserResponse login(@RequestBody LoginDto loginDto) {
        return UserResponse.builder()
                .id(2L)
                    .name("Manu")
                .phone("123456789")
                .email(loginDto.getEmail())
                .build();
    }
    @GetMapping("/logout")
    public UserResponse logout(@RequestBody String token) {
        return UserResponse.builder().build();
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserResponse user) {
        return user;
    }

    @GetMapping("/login/otp")
    public  Map<String, String> otp(@RequestBody String number) {
//        int otp = 10000 + new Random().nextInt(90000);
        int otp = ThreadLocalRandom.current().nextInt(10000, 100000);
        return  Map.of("otp", String.valueOf(otp));
    }

    @GetMapping("/email/verification")
    public String emailVerification(@RequestBody String email) {
        return "email verification";
    }

    @PostMapping("/forgot-password")
    public UserResponse forgotPassword(@RequestBody UserResponse user) {
        return user;
    }
}

//http://localhost:8080/login