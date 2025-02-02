package com.cda.cda.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FacultyProfile {

    @Id
    private Long userId;

    private String photo;

    private String officeHours;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

}
