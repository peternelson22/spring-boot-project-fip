package com.nelson.flexisaf.dto;

import com.nelson.flexisaf.entity.Qualification;
import com.nelson.flexisaf.entity.Qualification.QualificationType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeProfileDto {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String address;
    private String department;
    private String phoneMobile;
    private LocalDate employedDate;
    private BigDecimal salaryAmount;
    private List<QualificationType> qualificationTypes;
}
