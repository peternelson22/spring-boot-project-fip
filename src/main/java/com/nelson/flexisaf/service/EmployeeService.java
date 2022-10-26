package com.nelson.flexisaf.service;

import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.dto.EmployeeDto;
import com.nelson.flexisaf.dto.EmployeeProfileDto;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(EmployeeDto employeeDto);

    void updateEmployee(Long id, EmployeeDto employeeDto);

    void deleteEmployee(Long id);

    List<Employee> getEmployeeByNameContaining(String name);

    List<EmployeeDto> getAllEmployees(int pageNumber, int pageSize);

    String getFirstAndLastNameByEmail(String email);

    List<Employee> getEmployeeByDepartmentNameContaining(String name);

    EmployeeProfileDto getEmployeeProfile(String email);
}
