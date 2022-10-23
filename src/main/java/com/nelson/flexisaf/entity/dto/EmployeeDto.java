package com.nelson.flexisaf.entity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {

    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private LocalDate dateOfBirth;
    private String departmentName;
    /*private String address;
    private String phoneMobile;
    private String dependentName;
    private String nextOfKinMobile;
*/
}
