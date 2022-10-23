package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.entity.dto.SalaryDto;
import com.nelson.flexisaf.service.SalaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/salary")
public class SalaryController {

    private SalaryService salaryService;

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> salaryOfEmployee(String email, SalaryDto salaryDto){
        salaryService.saveEmployeeSalary(email, salaryDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
