package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.dto.DepartmentDto;
import com.nelson.flexisaf.exception.ResourceNotFoundException;
import com.nelson.flexisaf.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDto departmentDto) throws ResourceNotFoundException {
        departmentService.updateDepartment(id, departmentDto);
        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);
    }

}
