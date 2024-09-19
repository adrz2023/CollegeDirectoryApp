package com.cda.cda.entity;

import com.cda.cda.enums.Role;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;
}
