package com.nelson.flexisaf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @NotBlank
    @Column(nullable = false)
    private String deptName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();
}
