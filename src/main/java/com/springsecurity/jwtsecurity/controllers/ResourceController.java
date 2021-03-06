package com.springsecurity.jwtsecurity.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    
    @RequestMapping("/user")
    public String user(){
        return "Hello User";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "Hello Admin";
    }
}
