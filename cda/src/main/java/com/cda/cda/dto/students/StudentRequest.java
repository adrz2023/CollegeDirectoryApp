package com.cda.cda.dto.students;

import com.cda.cda.enums.Role;
import lombok.Data;

@Data
public class StudentRequest {
    private Long userId;
    private String photo;
    private Long departmentId;
    private String year;
}
