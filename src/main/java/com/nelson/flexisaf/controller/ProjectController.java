package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.dto.ProjectDto;
import com.nelson.flexisaf.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    @PostMapping("/save/{id}")
    public ResponseEntity<String> assignProjectsToDepartments(@PathVariable Long id, @RequestBody ProjectDto projectDto){
        projectService.assignProjectsToDepartments(id, projectDto);
        return new ResponseEntity<>("Successful", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProjects(@PathVariable Long id, @RequestBody ProjectDto projectDto){
        projectService.updateProjects(id, projectDto);
        return new ResponseEntity<>("Successful", HttpStatus.CREATED);
    }
}
