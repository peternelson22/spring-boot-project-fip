package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.dto.EmployeeDto;
import com.nelson.flexisaf.entity.dto.EmployeeProfileDto;
import com.nelson.flexisaf.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping ("/save")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return ResponseEntity.ok(employeeService.getAllEmployees(pageNumber, pageSize));
    }


    @GetMapping("/profile/{email}")
    public ResponseEntity<EmployeeProfileDto> getEmployeeProfile(@PathVariable String email){
        return ResponseEntity.ok(employeeService.getEmployeeProfile(email));
    }

    @GetMapping("/firstname/{firstname}")
    public ResponseEntity<List<Employee>> getEmployeeByNameIgnoreCase(@PathVariable("firstname") String firstName){
        return ResponseEntity.ok(employeeService.getEmployeeByNameIgnoreCase(firstName));
    }

    @GetMapping("/name/{name}")
    public List<Employee> getEmployeesByNameContaining(@PathVariable String name){
        return employeeService.getEmployeeByNameContaining(name);
    }


    @GetMapping("/fullname")
    public String getFirstAndLastNameByEmail(@RequestParam String email){
        return employeeService.getFirstAndLastNameByEmail(email);
    }


    @GetMapping("/dept/{name}")
    public List<Employee> getEmployeeByDepartmentName(@PathVariable String name){
        return employeeService.getEmployeeByDepartmentNameContaining(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "Successfully deleted";
    }



}
