package com.nelson.flexisaf.entity;

import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeUser {

    private Long id;
    private String username;
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
