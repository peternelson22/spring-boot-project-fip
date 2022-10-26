package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.dto.PayRollDto;
import com.nelson.flexisaf.entity.PayRoll;
import com.nelson.flexisaf.service.PayRollService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/payroll")
public class PayRollController {

    private PayRollService payRollService;

    @GetMapping("{email}")
    public ResponseEntity<List<PayRollDto>> getEmployeesPayRollDetails(@PathVariable String email){
        return ResponseEntity.ok(payRollService.getEmployeesPayRollDetails(email));
    }
}
