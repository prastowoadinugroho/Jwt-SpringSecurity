package com.springsecurity.jwtsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtSecurityApplication.class, args);
        System.out.println("=============================SERVER STARTED=============================");
    }
}
