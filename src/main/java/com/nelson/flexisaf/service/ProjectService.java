package com.nelson.flexisaf.service;

import com.nelson.flexisaf.dto.ProjectDto;

public interface ProjectService {

    void assignProjectsToDepartments(Long id, ProjectDto projectDto);

    void updateProjects(Long id, ProjectDto projectDto);
}
