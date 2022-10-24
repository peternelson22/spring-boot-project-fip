package com.nelson.flexisaf.service;

import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.entity.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    void assignDepartment(DepartmentDto departmentDto, Long id);
}
