package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.dto.EmployeeDto;
import com.nelson.flexisaf.dto.EmployeeProfileDto;
import com.nelson.flexisaf.entity.Qualification;
import com.nelson.flexisaf.entity.Qualification.QualificationType;
import com.nelson.flexisaf.exception.GenericApiException;
import com.nelson.flexisaf.exception.ResourceNotFoundException;
import com.nelson.flexisaf.repository.DepartmentRepository;
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

    private DepartmentRepository departmentRepository;

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee existingEmployee = employeeRepository.findByEmail(employeeDto.getEmail());
        if (existingEmployee != null) {
            log.info("Trying to register with an existing email");
            throw new GenericApiException("Email taken, please enter another email address");
        }
        Department department = Department.builder()
                .name(employeeDto.getDepartmentTypeName())
                .build();

        Employee employee = Employee.builder()
                .firstName(employeeDto.getFirstname())
                .lastName(employeeDto.getLastname())
                .dateOfBirth(employeeDto.getDateOfBirth())
                .gender(employeeDto.getGender())
                .email(employeeDto.getEmail())
                .employedDate(LocalDate.now())
                .sackedDate(null)
                .department(department)
                .build();

        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee existingEmployee = employeeRepository.findById(id).get();
        if (existingEmployee == null)
            throw new ResourceNotFoundException("Employee with id " + id + " does not exist");

        Department department = departmentRepository.findById(id).get();

        existingEmployee.setFirstName(employeeDto.getFirstname());
        existingEmployee.setEmail(employeeDto.getEmail());
        existingEmployee.setLastName(employeeDto.getLastname());
        existingEmployee.setDepartment(department);

        employeeRepository.save(existingEmployee);
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
    public EmployeeProfileDto getEmployeeProfile(String email) {
        Employee employee = employeeRepository.findByEmail(email);

        if (employee == null)
            throw new ResourceNotFoundException("No Employee found for this " + email);

        EmployeeProfileDto profileDto = new EmployeeProfileDto();
        profileDto.setEmail(employee.getEmail());
        profileDto.setGender(employee.getGender());
        profileDto.setAddress(employee.getContact().getAddress());
        profileDto.setLastName(employee.getLastName());
        profileDto.setFirstName(employee.getFirstName());
        profileDto.setPhoneMobile(employee.getContact().getPhoneMobile());
        profileDto.setSalaryAmount(employee.getSalary().getAmount());
        profileDto.setEmployedDate(employee.getEmployedDate());
        profileDto.setDepartmentType(employee.getDepartment().getName());
        //profileDto.setQualificationTypes(Enum.valueOf(QualificationType.));

        return profileDto;
    }

}
