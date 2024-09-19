package com.cda.cda.dto.students;

import com.cda.cda.dto.department.DepartmentResponse;
import com.cda.cda.dto.users.UserResponse;
import com.cda.cda.entity.Department;
import lombok.Data;

@Data
public class StudentResponse {
    private UserResponse userResponse;
    private String photo;
    private String year;
    private DepartmentResponse departmentResponse;
}
