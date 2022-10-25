package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Dependent;
import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.dto.DependentDto;
import com.nelson.flexisaf.repository.DependentRepository;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.service.DependentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DependentServiceImpl implements DependentService {

    private DependentRepository dependentRepository;

    private EmployeeRepository employeeRepository;

    @Override
    public void saveDependent(Long id, DependentDto dependentDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(IllegalStateException::new);

        Dependent dependent = new Dependent();
        dependent.setName(dependentDto.getName());
        dependent.setGender(dependentDto.getGender());
        dependent.setDateOfBirth(dependentDto.getDateOfBirth());
        dependent.setPhoneMobile(dependentDto.getPhoneMobile());
        dependent.setRelationship(dependentDto.getRelationship());
        dependent.setEmployee(employee);

        dependentRepository.save(dependent);
    }
}
