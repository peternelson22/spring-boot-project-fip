package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.Salary;
import com.nelson.flexisaf.dto.SalaryDto;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.repository.SalaryRepository;
import com.nelson.flexisaf.service.SalaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    private SalaryRepository salaryRepository;

    private EmployeeRepository employeeRepository;


    @Override
    public void saveEmployeeSalary(Long id, SalaryDto salaryDto) {
        Employee employee = employeeRepository.findById(id).get();

        if (employee == null){
            throw new IllegalStateException("Employee with " + id + " does not exit");
        }
        Salary salary = new Salary();
        salary.setAmount(salaryDto.getAmount());
        salary.setBonus(salaryDto.getBonus());
        salary.setDateTime(LocalDateTime.now());
        salary.setEmployee(employee);

        salaryRepository.save(salary);
    }
}
