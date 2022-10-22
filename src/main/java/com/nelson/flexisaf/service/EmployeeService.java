package com.nelson.flexisaf.service;

import com.nelson.flexisaf.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    Employee getEmployeeById(Long id);

    List<Employee> getEmployeeByNameIgnoreCase(String firstName);

    List<Employee> getEmployeeByNameContaining(String name);

    List<Employee> getAllEmployees();

    Employee getEmployeeByEmail(String email);

    String getFirstAndLastNameByEmail(String email);

    List<Employee> getEmployeeAndDepartment();

    List<Employee> getEmployeeByDepartmentName(String name);
}
