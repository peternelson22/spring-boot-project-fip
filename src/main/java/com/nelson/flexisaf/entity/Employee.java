package com.nelson.flexisaf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

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

    @Column(nullable = false)
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private String gender;

    @Transient
    private Integer age;

    @Column(nullable = false)
    private String employeePass;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate employedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sackedDate;


}
