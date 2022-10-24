package com.nelson.flexisaf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nelson.flexisaf.entity.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employees", uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email"))
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

    @NotBlank(message = "firstname must not be empty")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "lastname must not be empty")
    private String lastName;

    @Email(message = "Please enter a valid email address")
    @Column(nullable = false)
    private String email;

    private String gender;

    @Column(name = "DOB")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Transient
    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false, updatable = false)
    private LocalDate employedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sackedDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private Department department;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
    private Contact contact;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    private Dependent dependents;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    private Salary salary;



 public Integer getAge() {
          return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
         this.age = age;
    }
}
