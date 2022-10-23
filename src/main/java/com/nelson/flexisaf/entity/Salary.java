package com.nelson.flexisaf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Salary {

    @Id
    @SequenceGenerator(
            name = "salary_sequence",
            sequenceName = "salary_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "salary_sequence"
    )
    private Long id;

    private BigDecimal amount;

    private BigDecimal bonus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateTime;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
