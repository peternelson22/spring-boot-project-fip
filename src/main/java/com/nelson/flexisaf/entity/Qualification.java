package com.nelson.flexisaf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
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

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateIn;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public enum QualificationType {

        PHD,
        DEGREE,
        HND,
        NCE,
        SSCE,
        OTHERS

    }

}
