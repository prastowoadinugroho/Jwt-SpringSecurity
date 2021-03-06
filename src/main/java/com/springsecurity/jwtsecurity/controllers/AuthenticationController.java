package com.springsecurity.jwtsecurity.controllers;

import com.springsecurity.jwtsecurity.config.JwtUtil;
import com.springsecurity.jwtsecurity.config.MyUserDetailService;
import com.springsecurity.jwtsecurity.models.AuthenticationRequest;
import com.springsecurity.jwtsecurity.models.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authenticate")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private MyUserDetailService userDetailsService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @PostMapping("")
    public ResponseEntity<?> createAuthenticarion(@RequestBody AuthenticationRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("User Disabled", e);
        }
        catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials", e);
        }
        
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    } 
}
