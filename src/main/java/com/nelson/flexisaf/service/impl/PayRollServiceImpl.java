package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.dto.PayRollDto;
import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.PayRoll;
import com.nelson.flexisaf.entity.Salary;
import com.nelson.flexisaf.exception.ResourceNotFoundException;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.repository.PayRollRepository;
import com.nelson.flexisaf.repository.SalaryRepository;
import com.nelson.flexisaf.service.PayRollService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PayRollServiceImpl implements PayRollService {

    private PayRollRepository payRollRepository;
    private EmployeeRepository employeeRepository;
    private SalaryRepository salaryRepository;

    @Override
    public List<PayRollDto> getEmployeesPayRollDetails(String email) {
        List<PayRollDto> list = new ArrayList<>();
        Employee employee = employeeRepository.findByEmail(email);

        if (employee == null)
           throw  new ResourceNotFoundException("Employee with id " + email + " does not exist");

        List<Salary> salary = salaryRepository.findAll();
        salary.stream().forEach(s -> {
            PayRollDto payRollDto = PayRollDto.builder()
                    .employeeName(employee.getFirstName() + " " + employee.getLastName())
                    .amount(s.getAmount())
                    .dateTime(s.getDateTime())
                    .build();

            list.add(payRollDto);
        });

        return list;
    }
}
