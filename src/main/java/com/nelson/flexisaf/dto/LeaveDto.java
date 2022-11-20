package com.nelson.flexisaf.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LeaveDto {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfLeave;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private Integer weeksToSpend;

    private String employee;
}
