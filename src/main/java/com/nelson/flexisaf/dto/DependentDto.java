package com.nelson.flexisaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DependentDto {

    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String relationship;
    private String phoneMobile;
    private String employeeName;
}
