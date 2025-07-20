package org.rushrepo.backend.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Data @RequiredArgsConstructor @AllArgsConstructor @Builder 
public class AuthResponse {
    private String token;
    private String tokenType;  
    private Date expiresIn;     
}