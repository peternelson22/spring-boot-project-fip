package com.nelson.flexisaf.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class SalaryDto {

    private BigDecimal amount;

    private BigDecimal bonus;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;

    private Long employeeId;
}
