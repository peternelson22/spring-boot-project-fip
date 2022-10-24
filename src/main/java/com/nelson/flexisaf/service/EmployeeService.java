package com.nelson.flexisaf.service;

import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.dto.EmployeeDto;
import com.nelson.flexisaf.entity.dto.EmployeeProfileDto;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(EmployeeDto employeeDto);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    List<Employee> getEmployeeByNameIgnoreCase(String firstName);

    List<Employee> getEmployeeByNameContaining(String name);

    List<Employee> getAllEmployees(int pageNumber, int pageSize);

    String getFirstAndLastNameByEmail(String email);

    List<Employee> getEmployeeByDepartmentNameContaining(String name);

    EmployeeProfileDto getEmployeeProfile(String email);
}
