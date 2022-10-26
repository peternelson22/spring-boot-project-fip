package com.nelson.flexisaf.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DependentDto {

    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String relationship;
    private String phoneMobile;
    private Long employeeId;
}
