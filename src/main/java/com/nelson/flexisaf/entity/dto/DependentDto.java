package com.nelson.flexisaf.entity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DependentDto {

    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String relationship;
    private String phoneMobile;
    private Long employeeId;
}
