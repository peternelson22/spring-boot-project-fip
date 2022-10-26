package com.nelson.flexisaf.dto;

import com.nelson.flexisaf.entity.Department.DepartmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private DepartmentType name;

}
