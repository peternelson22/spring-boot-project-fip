package com.nelson.flexisaf.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SalaryDto {

    private BigDecimal amount;

    private BigDecimal bonus;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;

    private Long employeeId;
}
