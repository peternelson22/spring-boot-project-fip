package com.nelson.flexisaf.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

public class Qualification {

    @SequenceGenerator(
            name = "qualification_sequence",
            sequenceName = "qualification_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "qualification_sequence"
    )
    private Long id;

    private String type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateIn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
