package com.nelson.flexisaf.service;

import com.nelson.flexisaf.dto.EmployeeDto;
import com.nelson.flexisaf.dto.EmployeeProfileDto;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(EmployeeDto employeeDto);

    void updateEmployee(Long id, EmployeeDto employeeDto);

    void deleteEmployee(Long id);

    List<EmployeeDto> getEmployeeByNameIgnoreCase(String name);

    List<EmployeeDto> getAllEmployees(int pageNumber, int pageSize);

    String getFirstAndLastNameByEmail(String email);

    EmployeeProfileDto getEmployeeProfile(String email);
}
