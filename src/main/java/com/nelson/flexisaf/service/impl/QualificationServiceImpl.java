package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.Qualification;
import com.nelson.flexisaf.entity.dto.QualificationDto;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.repository.QualificationRepository;
import com.nelson.flexisaf.service.QualificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QualificationServiceImpl implements QualificationService {

    private QualificationRepository qualificationRepository;

    private EmployeeRepository employeeRepository;

    @Override
    public void saveQualification(Long id, QualificationDto qualificationDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalStateException("NOT FOUND"));

        Qualification qualification = new Qualification();
        qualification.setQualificationType(qualificationDto.getQualificationType());
        qualification.setDateIn(qualificationDto.getDateIn());
        qualification.setEmployee(employee);

        qualificationRepository.save(qualification);
    }
}
