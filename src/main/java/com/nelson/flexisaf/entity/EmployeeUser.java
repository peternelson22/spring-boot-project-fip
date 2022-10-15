package com.nelson.flexisaf.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeUser {

    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Email
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
