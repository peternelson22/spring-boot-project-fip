package com.nelson.flexisaf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dependent {

    @SequenceGenerator(
            name = "dependent_sequence",
            sequenceName = "dependent_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dependent_sequence"
    )
    private Long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @Transient
    private Integer age;

    private String sex;

    private String relationship;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
