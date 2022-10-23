package com.nelson.flexisaf.service;

import com.nelson.flexisaf.entity.dto.SalaryDto;

public interface SalaryService {

    void saveEmployeeSalary(String email, SalaryDto salaryDto);
}
