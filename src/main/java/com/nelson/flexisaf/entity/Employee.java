package com.nelson.flexisaf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee{

    @Id
   @SequenceGenerator(
           name = "employee_sequence",
           sequenceName = "employee_sequence",
           allocationSize = 1
   )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Email
    @Column(nullable = false)
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private String gender;

    @Transient
    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false, updatable = false)
    private LocalDate employedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sackedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private Department department;
    


}
