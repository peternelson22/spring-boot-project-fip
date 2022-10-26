package com.nelson.flexisaf.dto;

import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.entity.Department.DEPARTMENT;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentDto {

    private DEPARTMENT name;

    private Long employeeId;
}
