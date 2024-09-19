package com.cda.cda.dto.users;

import com.cda.cda.enums.Role;
import lombok.Data;

@Data
public class UserSignUpRequest {
    private String name;
    private Role role;
    private String username;
    private String password;
    private String email;
    private String phone;
}
