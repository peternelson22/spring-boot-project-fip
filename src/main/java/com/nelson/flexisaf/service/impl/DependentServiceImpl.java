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

import java.util.ArrayList;
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
    public List<DependentDto> getEmployeeDependentDetails(String email) {
        List<DependentDto> dependentDto = new ArrayList<>();
        Employee employee = employeeRepository.findByEmail(email);

        if (employee == null)
            throw new ResourceNotFoundException("No employee found with email " + email);

        List<Dependent> dependent = dependentRepository.findAll();
        dependent.forEach(d -> {
            DependentDto dto = DependentDto.builder()
                    .employeeName(d.getEmployee().getFirstName() + " " + d.getEmployee().getLastName())
                    .name(d.getName())
                    .gender(d.getGender())
                    .dateOfBirth(d.getDateOfBirth())
                    .phoneMobile(d.getPhoneMobile())
                    .relationship(d.getRelationship())
                    .build();
            dependentDto.add(dto);
        });

        return dependentDto;
    }
}
