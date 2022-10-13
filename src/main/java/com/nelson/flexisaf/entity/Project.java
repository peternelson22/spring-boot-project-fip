package com.nelson.flexisaf.entity;

import java.time.LocalDate;

public class Project {

    private Long id;
    private String projectName;
    private String desc;
    private LocalDate startDate;
    private LocalDate endDate;
    private Department department;
}
