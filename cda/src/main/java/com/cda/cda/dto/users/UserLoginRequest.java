package com.cda.cda.dto.users;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String email;
    private String password;
}
