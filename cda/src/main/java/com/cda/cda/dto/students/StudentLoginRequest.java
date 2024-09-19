package com.cda.cda.dto.students;

import lombok.Data;

@Data
public class StudentLoginRequest {
    private String email;
    private String password;
}
