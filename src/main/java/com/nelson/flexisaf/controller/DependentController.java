package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.dto.DependentDto;
import com.nelson.flexisaf.exception.ResourceNotFoundException;
import com.nelson.flexisaf.service.DependentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/dependent")
public class DependentController {

    private DependentService dependentService;

    @PostMapping("/save/{id}")
    public ResponseEntity<String> saveDependent(@PathVariable Long id, @RequestBody DependentDto dependentDto){
            dependentService.saveDependent(id, dependentDto);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDependentInfo(@PathVariable Long id, @RequestBody DependentDto dependentDto) throws ResourceNotFoundException {
        dependentService.updateDependentInfo(id, dependentDto);
        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);
    }

    @GetMapping("/details/{email}")
    public ResponseEntity<List<DependentDto>> getEmployeeDependentDetails(@PathVariable String email){
        return ResponseEntity.ok(dependentService.getEmployeeDependentDetails(email));
    }

}
