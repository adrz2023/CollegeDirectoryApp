package com.cda.cda.dto.department;

import com.cda.cda.entity.AdministratorProfile;
import com.cda.cda.entity.Course;
import com.cda.cda.entity.FacultyProfile;
import com.cda.cda.entity.StudentProfile;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentResponse {

    private Long id;
    private String name;
    private String description;
    private List<FacultyProfile> facultyMembers;
    private List<AdministratorProfile> administrators;
    private List<Course> courses;
}
