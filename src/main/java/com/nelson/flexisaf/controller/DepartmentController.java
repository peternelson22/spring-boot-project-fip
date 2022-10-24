package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.entity.dto.DepartmentDto;
import com.nelson.flexisaf.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("/save/{id}")
    public ResponseEntity<String> assignDepartment(@PathVariable Long id, @RequestBody DepartmentDto departmentDto){
        departmentService.assignDepartment(departmentDto, id);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }
}
