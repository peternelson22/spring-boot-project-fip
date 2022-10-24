package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.dto.DepartmentDto;
import com.nelson.flexisaf.repository.DepartmentRepository;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private EmployeeRepository employeeRepository;

    @Override
    public void assignDepartment(DepartmentDto departmentDto, Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(IllegalAccessError::new);

        Department department = new Department();
        department.setName(departmentDto.getName());
        employee.setDepartment(department);

        departmentRepository.save(department);
    }
}
