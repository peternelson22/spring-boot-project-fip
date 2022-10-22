package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Employee with id " + id + " does not exist"));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalStateException("NOT FOUND"));
    }

    @Override
    public List<Employee> getEmployeeByNameIgnoreCase(String firstName) {
        return employeeRepository.findByFirstNameIgnoreCase(firstName);
    }

    @Override
    public List<Employee> getEmployeeByNameContaining(String name) {
        return employeeRepository.findByFirstNameContaining(name);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public String getFirstAndLastNameByEmail(String email) {
        return employeeRepository.getEmployeeFirstNameAndLastNameByEmail(email);
    }

    @Override
    public List<Employee> getEmployeeAndDepartment() {
        return employeeRepository.getEmployeeAndDepartment();
    }

    @Override
    public List<Employee> getEmployeeByDepartmentName(String name) {
        return employeeRepository.findByDepartmentNameIgnoreCase(name);
    }


}
