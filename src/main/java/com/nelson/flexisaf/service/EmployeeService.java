package com.nelson.flexisaf.service;

import com.nelson.flexisaf.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    Employee getEmployeeById(Long id);

    List<Employee> getEmployeeByNameIgnoreCase(String firstName);

    List<Employee> getEmployeeByNameContaining(String name);
}
