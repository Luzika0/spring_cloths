package com.example.Spring_Cloths.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

import com.example.Spring_Cloths.dto.trance.loginRequest;
import com.example.Spring_Cloths.dto.trance.registerRequest;
import com.example.Spring_Cloths.models.users;
import com.example.Spring_Cloths.repository.securityReepository;
import com.example.Spring_Cloths.security.jwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private jwtService jwtService;

    @Autowired
    private securityReepository repo;

    @Autowired
    private PasswordEncoder encoder;

    // TEST
   

    // REGISTER
    @Hidden
    @PostMapping("/register")
    public String register(@RequestBody registerRequest request) {

        users user = new users();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        repo.save(user);

        return "User registered successfully";
    }

    // LOGIN
    @Hidden
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody loginRequest request) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token = jwtService.generateToken(request.getUsername());
        Map<String, String> response = new HashMap<>();
        response.put("jwtToken", token);
        return ResponseEntity.ok(response);
    }

}