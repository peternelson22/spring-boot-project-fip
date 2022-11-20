package com.nelson.flexisaf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "payroll")
public class PayRoll {

    @Id
    @SequenceGenerator(
            name = "payroll_sequence",
            sequenceName = "payroll_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payroll_sequence"
    )
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;

    private BigDecimal amount;

    @ManyToMany(fetch = EAGER, cascade =  ALL)
    @JoinTable(name = "employee_payroll",
            joinColumns = @JoinColumn(name = "salary_id"),
            inverseJoinColumns = @JoinColumn(name = "payroll_id")
    )
    private List<Salary> salary;



}
