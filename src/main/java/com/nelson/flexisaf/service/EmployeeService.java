package com.nelson.flexisaf.service;

import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(EmployeeDto employeeDto);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    List<Employee> getEmployeeByNameIgnoreCase(String firstName);

    List<Employee> getEmployeeByNameContaining(String name);

    List<Employee> getAllEmployees(int pageNumber, int pageSize);

    Employee getEmployeeByEmail(String email);

    String getFirstAndLastNameByEmail(String email);

    List<Employee> getEmployeeAndDepartment();

    List<Employee> getEmployeeByDepartmentNameContaining(String name);

    EmployeeDto getEmployeeById(Long id);
}
