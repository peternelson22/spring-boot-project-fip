package com.nelson.flexisaf.dto;

import com.nelson.flexisaf.entity.Department.DepartmentType;
import com.nelson.flexisaf.entity.Qualification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.nelson.flexisaf.entity.Qualification.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeProfileDto {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String address;
    private DepartmentType departmentType;
    private String phoneMobile;
    private LocalDate employedDate;
    private BigDecimal salaryAmount;
}
