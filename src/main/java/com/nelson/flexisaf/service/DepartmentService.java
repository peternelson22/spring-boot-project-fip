package com.nelson.flexisaf.service;

import com.nelson.flexisaf.dto.DepartmentDto;
import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.exception.ResourceNotFoundException;

public interface DepartmentService {

    void assignDepartment(DepartmentDto departmentDto, Long id);

    void updateDepartment(Long id, DepartmentDto departmentDto) throws ResourceNotFoundException;

    void deleteEmployeeDepartment(Long id);
}
