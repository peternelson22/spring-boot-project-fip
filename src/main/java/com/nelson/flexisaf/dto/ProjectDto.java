package com.nelson.flexisaf.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nelson.flexisaf.entity.Project.ProjectStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ProjectDto {

    private String projectName;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private ProjectStatus projectStatus;

}
