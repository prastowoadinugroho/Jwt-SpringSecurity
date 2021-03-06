package com.springsecurity.jwtsecurity.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;
        if(username.equals("admin"))
        {
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User("admin","$2a$10$36Ro7gxLU./zKLciishIr.lpSKfanBZ1uPxMm5RH3pedmnM06MZdW",roles);
        }
        if(username.equals("user"))
        {
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            return new User("user","$2a$10$vyNTP5Bpk38KpQam2Cu3Vu4UHHbv8a7AP6pLDbAvoZKrH/9VmVH5S",roles);
        }
        throw new UsernameNotFoundException("Username not found with name " + username);
    }
    
}
