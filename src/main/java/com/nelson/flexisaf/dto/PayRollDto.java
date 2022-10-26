package com.nelson.flexisaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayRollDto {

    private String employeeName;

    private BigDecimal amount;

    private LocalDateTime dateTime;

}
