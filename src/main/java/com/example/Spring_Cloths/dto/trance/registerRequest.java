package com.example.Spring_Cloths.dto.trance;
import com.example.Spring_Cloths.enums.role;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class registerRequest {
    
    private String username;
    
    private String password;
    
    private String confirmPassword;
    private role role;
}
