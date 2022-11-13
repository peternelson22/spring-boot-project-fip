package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.PayRoll;
import com.nelson.flexisaf.entity.Salary;
import com.nelson.flexisaf.dto.SalaryDto;
import com.nelson.flexisaf.exception.ResourceNotFoundException;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.repository.PayRollRepository;
import com.nelson.flexisaf.repository.SalaryRepository;
import com.nelson.flexisaf.service.SalaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    private SalaryRepository salaryRepository;

    private EmployeeRepository employeeRepository;

    private PayRollRepository payRollRepository;


    @Override
    public void saveEmployeeSalary(Long id, SalaryDto salaryDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee with " + id + " does not exit"));

        Salary salary = Salary.builder()
                .amount(salaryDto.getAmount())
                .bonus(salaryDto.getBonus())
                .dateTime(LocalDateTime.now())
                .employee(employee)
                .build();

        PayRoll payRoll = PayRoll.builder()
                .paymentDate(LocalDate.now())
                .salary(List.of(salary))
                .amount(salaryDto.getAmount())
                .build();

        salaryRepository.save(salary);

        payRollRepository.save(payRoll);
    }


}
