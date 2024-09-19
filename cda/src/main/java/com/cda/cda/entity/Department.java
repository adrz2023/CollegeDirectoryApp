package com.cda.cda.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<StudentProfile> students;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<FacultyProfile> facultyMembers;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<AdministratorProfile> administrators;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Course> courses;

}

