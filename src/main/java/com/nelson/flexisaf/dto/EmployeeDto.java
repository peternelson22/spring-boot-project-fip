package com.nelson.flexisaf.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nelson.flexisaf.entity.Department.DepartmentType;
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
    @JsonIgnore
    private LocalDate dateOfBirth;
    private DepartmentType departmentTypeName;


}
