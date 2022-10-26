package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.dto.ProjectDto;
import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.entity.Project;
import com.nelson.flexisaf.exception.ResourceNotFoundException;
import com.nelson.flexisaf.repository.DepartmentRepository;
import com.nelson.flexisaf.repository.ProjectRepository;
import com.nelson.flexisaf.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    private DepartmentRepository departmentRepository;

    @Override
    public void assignProjectsToDepartments(Long id, ProjectDto projectDto) {
        Department department = departmentRepository.findById(id).orElseThrow(() ->
                 new ResourceNotFoundException("Department not found"));

        Project project = Project.builder()
                .projectName(projectDto.getProjectName())
                .description(projectDto.getDescription())
                .projectStatus(projectDto.getProjectStatus())
                .startDate(projectDto.getStartDate())
                .endDate(null)
                .department(department)
                .build();

        projectRepository.save(project);
    }

    @Override
    public void updateProjects(Long id, ProjectDto projectDto) {
        Department department = departmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee with id " + id + " does not exist"));

        Project project = projectRepository.findById(id).get();
        project.setProjectStatus(projectDto.getProjectStatus());
        project.setEndDate(projectDto.getEndDate());
        project.setProjectName(projectDto.getProjectName());
        project.setDepartment(department);

        projectRepository.save(project);
    }
}
