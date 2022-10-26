package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Dependent;
import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.dto.DependentDto;
import com.nelson.flexisaf.exception.ResourceNotFoundException;
import com.nelson.flexisaf.repository.DependentRepository;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.service.DependentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DependentServiceImpl implements DependentService {

    private DependentRepository dependentRepository;

    private EmployeeRepository employeeRepository;

    @Override
    public void saveDependent(Long id, DependentDto dependentDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee with id " + id + " does not exist"));

        Dependent dependent = Dependent.builder()
                .name(dependentDto.getName())
                .dateOfBirth(dependentDto.getDateOfBirth())
                .gender(dependentDto.getGender())
                .phoneMobile(dependentDto.getPhoneMobile())
                .relationship(dependentDto.getRelationship())
                .employee(employee)
                .build();

        dependentRepository.save(dependent);
    }

    @Override
    public void updateDependentInfo(Long id, DependentDto dependentDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee with id " + id + " does not exist"));

        Dependent dependent = dependentRepository.findById(id).get();
        dependent.setName(dependentDto.getName());
        dependent.setPhoneMobile(dependentDto.getPhoneMobile());
        dependent.setEmployee(employee);

        dependentRepository.save(dependent);
    }

    @Override
    public DependentDto getEmployeeDependentDetails(String email) {
        Optional<Employee> employee = employeeRepository.findByEmail(email);

        if (!employee.isPresent())
            throw new ResourceNotFoundException("No employee found with email " + email);

        Dependent dependent = new Dependent();
        DependentDto dependentDto = DependentDto.builder()
                .name(dependent.getName())
                .dateOfBirth(dependent.getDateOfBirth())
                .gender(dependent.getGender())
                .relationship(dependent.getRelationship())
                .phoneMobile(dependent.getPhoneMobile())
                .employeeName(dependent.getEmployee().getFirstName() + " " + dependent.getEmployee().getLastName())
                .build();

        return dependentDto;
    }
}
