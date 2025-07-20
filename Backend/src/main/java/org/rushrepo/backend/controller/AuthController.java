package org.rushrepo.backend.controller;

import org.rushrepo.backend.dto.AuthResponse;
import org.rushrepo.backend.dto.LoginRequest;
import org.rushrepo.backend.dto.RegisterRequest;
import org.rushrepo.backend.dto.UserDto;
import org.rushrepo.backend.service.JwtService;
import org.rushrepo.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public AuthResponse createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String jwt = jwtService.generateToken(userDetails);

        return new AuthResponse(jwt, "Bearer", jwtService.extractExpiration(jwt));
    }
    
    
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterRequest request) {
        UserDto newUser = userService.registerUser(request);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    
}