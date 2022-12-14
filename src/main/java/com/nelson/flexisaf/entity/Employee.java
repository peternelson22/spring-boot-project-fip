package com.nelson.flexisaf.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employees", uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email"))
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;

    @NotBlank(message = "Firstname must not be empty")
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

    @ManyToOne(cascade = ALL, fetch = LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;

    @OneToOne(cascade = ALL, mappedBy = "employee")
    private Contact contact;

    @OneToMany(fetch = LAZY, cascade = ALL, mappedBy = "employee")
    private List<Dependent> dependents;

    @OneToMany(fetch = LAZY, cascade = ALL, mappedBy = "employee")
    private List<Qualification> qualifications;

    @OneToOne(cascade = ALL, mappedBy = "employee")
    private Salary salary;

    @OneToMany(fetch = LAZY, cascade = ALL, mappedBy = "employee")
    private List<Leave> leave;

    @ManyToMany(mappedBy = "employees", cascade = ALL)
    private List<GuestLog> guestLogs;


    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
