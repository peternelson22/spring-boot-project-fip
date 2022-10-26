package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.dto.EmployeeDto;
import com.nelson.flexisaf.dto.EmployeeProfileDto;
import com.nelson.flexisaf.exception.GenericApiException;
import com.nelson.flexisaf.exception.ResourceNotFoundException;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> existingEmployee = employeeRepository.findByEmail(employeeDto.getEmail());
        if (existingEmployee.isPresent()) {
            log.info("Trying to register with an existing email");
            throw new GenericApiException("Email taken, please enter another email address");
        }
        Employee employee = Employee.builder()
                .firstName(employeeDto.getFirstname())
                .lastName(employeeDto.getLastname())
                .dateOfBirth(employeeDto.getDateOfBirth())
                .gender(employeeDto.getGender())
                .email(employeeDto.getEmail())
                .employedDate(LocalDate.now())
                .sackedDate(null)
                .build();

        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Long id, EmployeeDto employeeDto) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
            if (!existingEmployee.isPresent())
                throw new ResourceNotFoundException("Employee with id " + id + " does not exist");
        Employee employee = Employee.builder()
                .firstName(employeeDto.getFirstname())
                .lastName(employeeDto.getLastname())
                .build();

        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    //SORTING
    @Override
    public List<Employee> getEmployeeByNameContaining(String name) {
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        return employeeRepository.findByFirstNameContaining(name, sort);
    }

    //PAGINATION & SORTING
    @Override
    public List<EmployeeDto> getAllEmployees(int pageNumber, int pageSize) {
        List<EmployeeDto> list = new ArrayList<>();
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "firstName");
        List<Employee> employee = employeeRepository.findAll(pages).getContent();
        employee.forEach(e -> {

        EmployeeDto employeeDto = EmployeeDto.builder()
                .firstname(e.getFirstName())
                .lastname(e.getLastName())
                .email(e.getEmail())
                .dateOfBirth(e.getDateOfBirth())
                .gender(e.getGender())
                .departmentTypeName(e.getDepartment().getName())
                .build();
        list.add(employeeDto);

        });
        return list;
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
        Optional<Employee> e = employeeRepository.findByEmail(email);
        if (!e.isPresent())
            throw new ResourceNotFoundException("Employee with email " + email + " is not available");

        Employee employee = new Employee();
        EmployeeProfileDto employeeProfileDto = EmployeeProfileDto.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .gender(employee.getGender())
                .address(employee.getContact().getAddress())
                .departmentType(employee.getDepartment().getName())
                .salaryAmount(employee.getSalary().getAmount())
                .phoneMobile(employee.getContact().getPhoneMobile())
                .employedDate(employee.getEmployedDate())
                .build();

        return employeeProfileDto;
    }

}
