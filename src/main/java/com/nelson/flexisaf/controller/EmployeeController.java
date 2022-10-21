package com.nelson.flexisaf.controller;


import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping ("/employee/save")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/employee/firstname/{firstname}")
    public ResponseEntity<List<Employee>> getEmployeeByNameIgnoreCase(@PathVariable("firstname") String firstName){
        return ResponseEntity.ok(employeeService.getEmployeeByNameIgnoreCase(firstName));
    }

    @GetMapping("/employees/{name}")
    public List<Employee> getEmployeeByNameContaining(@PathVariable String name){
        return employeeService.getEmployeeByNameContaining(name);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "Successfully deleted";
    }


}
