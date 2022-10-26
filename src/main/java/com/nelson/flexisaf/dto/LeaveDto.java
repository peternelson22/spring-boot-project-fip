package com.nelson.flexisaf.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LeaveDto {

    private LocalDate dateOfLeave;

    private LocalDate endDate;

    private Integer weeksToSpend;

    private String employee;
}
