package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.entity.dto.SalaryDto;
import com.nelson.flexisaf.service.SalaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/salary")
public class SalaryController {

    private SalaryService salaryService;

    @PostMapping("/save/{id}")
    public ResponseEntity<HttpStatus> salaryOfEmployee(@PathVariable Long id, @RequestBody SalaryDto salaryDto){
        salaryService.saveEmployeeSalary(id, salaryDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
