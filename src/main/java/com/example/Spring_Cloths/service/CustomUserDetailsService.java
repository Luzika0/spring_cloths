package com.example.Spring_Cloths.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.Spring_Cloths.models.users;
import com.example.Spring_Cloths.repository.securityReepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private securityReepository repo;
    
    @Override
    public UserDetails loadUserByUsername(String username) {
        users user=repo.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
        );
    }

    
}