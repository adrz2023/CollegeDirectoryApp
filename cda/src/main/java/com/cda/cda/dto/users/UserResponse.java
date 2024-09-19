package com.cda.cda.dto.users;

import com.cda.cda.enums.Role;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private Role role;
    private String username;
    private String email;
    private String phone;
}
