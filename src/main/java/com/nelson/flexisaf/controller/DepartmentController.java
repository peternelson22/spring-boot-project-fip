package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }
}
