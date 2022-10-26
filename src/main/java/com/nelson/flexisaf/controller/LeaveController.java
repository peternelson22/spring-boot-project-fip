package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.dto.LeaveDto;
import com.nelson.flexisaf.service.LeaveService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/leave")
public class LeaveController {

    private LeaveService leaveService;

    @PostMapping("/save/{id}")
    public ResponseEntity<String> saveLeaveDetails(@PathVariable Long id, @RequestBody LeaveDto leaveDto){
        leaveService.saveLeaveDetails(id, leaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{email}")
    public ResponseEntity<List<LeaveDto>> getEmployeeLeaveDetails(@PathVariable String email){
        return ResponseEntity.ok(leaveService.getEmployeeLeaveDetails(email));
    }


}
