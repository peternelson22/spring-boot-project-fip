package com.nelson.flexisaf.entity.dto;

import com.nelson.flexisaf.entity.Department;
import lombok.Data;

@Data
public class DepartmentDto {

    private Department.DEPARTMENT name;
    private Long employee_id;
}
