package com.nelson.flexisaf.controller;


import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.dto.EmployeeDto;
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
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return ResponseEntity.ok(employeeService.getAllEmployees(pageNumber, pageSize));
    }

    @GetMapping("/employee/id/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/employee/firstname/{firstname}")
    public ResponseEntity<List<Employee>> getEmployeeByNameIgnoreCase(@PathVariable("firstname") String firstName){
        return ResponseEntity.ok(employeeService.getEmployeeByNameIgnoreCase(firstName));
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> getEmployeesByNameContaining(@PathVariable String name){
        return employeeService.getEmployeeByNameContaining(name);
    }

    @GetMapping("/employee/email/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email){
        return ResponseEntity.ok(employeeService.getEmployeeByEmail(email));
    }

    @GetMapping("/employee/fullname")
    public String getFirstAndLastNameByEmail(@RequestParam String email){
        return employeeService.getFirstAndLastNameByEmail(email);
    }

    @GetMapping("/employee/full")
    public List<Employee> getEmployeesAndDepartments(){
        return employeeService.getEmployeeAndDepartment();
    }

    @GetMapping("employees/dept/{name}")
    public List<Employee> getEmployeeByDepartmentName(@PathVariable String name){
        return employeeService.getEmployeeByDepartmentNameContaining(name);
    }

    //TODO: use email to update
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.CREATED);
    }

    //TODO: use email to delete
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "Successfully deleted";
    }



}
