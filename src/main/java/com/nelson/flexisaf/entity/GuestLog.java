package com.nelson.flexisaf.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "guest_logs")
public class GuestLog {

    @Id
    @SequenceGenerator(name = "guest_seq", sequenceName = "guest_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_seq")
    private Long id;

    private String description;

    private String visitorName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;


    @ManyToMany(cascade = DETACH)
    @JoinTable(name = "employee_guests", joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id"))
    private List<Employee> employees;


}
