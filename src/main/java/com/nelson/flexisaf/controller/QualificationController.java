package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.dto.QualificationDto;
import com.nelson.flexisaf.service.QualificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/qualification")
public class QualificationController {

    private QualificationService qualificationService;

    @PostMapping("/save/{id}")
    public ResponseEntity<String> saveQualification(@PathVariable Long id, @RequestBody QualificationDto qualificationDto){
        qualificationService.saveQualification(id, qualificationDto);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateQualification(@PathVariable Long id, @RequestBody QualificationDto qualificationDto){
        qualificationService.updateQualification(id, qualificationDto);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
