package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.Qualification;
import com.nelson.flexisaf.dto.QualificationDto;
import com.nelson.flexisaf.exception.ResourceNotFoundException;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.repository.QualificationRepository;
import com.nelson.flexisaf.service.QualificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QualificationServiceImpl implements QualificationService {

    private QualificationRepository qualificationRepository;

    private EmployeeRepository employeeRepository;

    @Override
    public void saveQualification(Long id, QualificationDto qualificationDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee with id  + id +  does not exist"));

        Qualification qualification = Qualification.builder()
                .qualificationType(qualificationDto.getQualificationType())
                .dateIn(qualificationDto.getDateIn())
                .employee(employee)
                .build();

        qualificationRepository.save(qualification);
    }

    @Override
    public void updateQualification(Long id, QualificationDto qualificationDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee with id  + id +  does not exist"));

        Qualification qualification = qualificationRepository.findById(id).get();
        qualification.setDateIn(qualificationDto.getDateIn());
        qualification.setQualificationType(qualificationDto.getQualificationType());
        qualification.setEmployee(employee);

        qualificationRepository.save(qualification);
    }
}
