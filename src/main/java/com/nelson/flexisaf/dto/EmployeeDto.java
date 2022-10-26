package com.nelson.flexisaf.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.entity.Department.DEPARTMENT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private DEPARTMENT departmentName;


}
