package com.nelson.flexisaf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Qualification {

    @Id
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

    @Enumerated(EnumType.STRING)
    @Column(name = "qual_type", nullable = false)
    private QualificationType qualificationType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateIn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public enum QualificationType{
        DEGREE, HND, NCE, SSCE, OTHERS
    }
}
