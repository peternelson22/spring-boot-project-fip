package com.nelson.flexisaf.entity.dto;

import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.entity.Department.DEPARTMENT;
import lombok.Data;

@Data
public class DepartmentDto {

    private DEPARTMENT name;

    private Long employeeId;
}
