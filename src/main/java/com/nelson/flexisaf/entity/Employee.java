package com.nelson.flexisaf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @NotBlank
    @Column(nullable = false)
    @NotEmpty(message = "first name must not be empty")
    private String firstName;

    @NotEmpty(message = "last name must not be empty")
    private String lastName;

    @Email
    @Column(nullable = false)
    private String email;

    private String gender;

    @Column(name = "DOB")
    private LocalDate dateOfBirth;

    @Transient
    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false, updatable = false)
    private LocalDate employedDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sackedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
    private Contact contact;


    public Integer getAge() {
          return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
         this.age = age;
    }
}
