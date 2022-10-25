package com.nelson.flexisaf.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {

    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String departmentName;


}
