package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.dto.DependentDto;
import com.nelson.flexisaf.service.DependentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
