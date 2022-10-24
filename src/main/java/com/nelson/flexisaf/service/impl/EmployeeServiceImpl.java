package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.Qualification;
import com.nelson.flexisaf.entity.dto.EmployeeDto;
import com.nelson.flexisaf.entity.dto.EmployeeProfileDto;
import com.nelson.flexisaf.repository.DepartmentRepository;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstname());
        employee.setLastName(employeeDto.getLastname());
        employee.setEmail(employeeDto.getEmail());
        employee.setGender(employeeDto.getGender());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setEmployedDate(LocalDate.now());
        employee.setSackedDate(null);

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
    public List<Employee> getEmployeeByNameIgnoreCase(String firstName) {
        return employeeRepository.findByFirstNameIgnoreCase(firstName);
    }

    //SORTING
    @Override
    public List<Employee> getEmployeeByNameContaining(String name) {
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        return employeeRepository.findByFirstNameContaining(name, sort);
    }

    //PAGINATION & SORTING
    @Override
    public List<Employee> getAllEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id");
        return employeeRepository.findAll(pages).getContent();
    }


    @Override
    public String getFirstAndLastNameByEmail(String email) {
        return employeeRepository.getEmployeeFirstNameAndLastNameByEmail(email);
    }


    @Override
    public List<Employee> getEmployeeByDepartmentNameContaining(String name) {
        return employeeRepository.findByDepartmentNameContaining(name);
    }

    @Override
    public EmployeeProfileDto getEmployeeProfile(String email) {
        EmployeeProfileDto employeeProfileDto = new EmployeeProfileDto();

        Employee employee = employeeRepository.findByEmail(email);
        employeeProfileDto.setAddress(employee.getContact().getAddress());
        employeeProfileDto.setGender(employee.getGender());
        employeeProfileDto.setEmail(employee.getEmail());
        employeeProfileDto.setPhoneMobile(employee.getContact().getPhoneMobile());
        employeeProfileDto.setFirstName(employee.getFirstName());
        employeeProfileDto.setLastName(employee.getLastName());
        employeeProfileDto.setEmployedDate(employee.getEmployedDate());
        employeeProfileDto.setDepartment(employee.getDepartment().getName().name());
        employeeProfileDto.setSalaryAmount(employee.getSalary().getAmount());

        return employeeProfileDto;
    }

    /*@Override
    public EmployeeDto getEmployeeByEmail(String email) {
        EmployeeDto employeeDto = new EmployeeDto();
        Employee employee = employeeRepository.findByEmail(email);

        employeeDto.setFirstname(employee.getFirstName());
        employeeDto.setLastname(employee.getLastName());
        employeeDto.setDepartmentName(employee.getDepartment().getName());
        employeeDto.setGender(employee.getGender());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDateOfBirth(employee.getDateOfBirth());

        return employeeDto;
    }
*/

}
