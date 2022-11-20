package com.nelson.flexisaf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "departments")
public class Department {

    @Id
    @SequenceGenerator(
            name = "dept_sequence",
            sequenceName = "dept_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dept_sequence"
    )
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DepartmentType name;

    @OneToMany(fetch = LAZY, mappedBy = "department")
    private List<Employee> employee;

    @OneToMany(fetch = LAZY, mappedBy = "department", cascade = ALL)
    private List<Project> projects;


    public enum DepartmentType {
        BACKEND,
        FRONTEND,
        DESIGN
    }
}
