package org.rushrepo.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RegisterRequest {  
    private String username;
    @Email private String email;
    @NotBlank @Size(min = 8) private String password;
}

