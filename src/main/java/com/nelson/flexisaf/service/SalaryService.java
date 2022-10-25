package com.nelson.flexisaf.service;

import com.nelson.flexisaf.dto.SalaryDto;

public interface SalaryService {

    void saveEmployeeSalary(Long id, SalaryDto salaryDto);
}
