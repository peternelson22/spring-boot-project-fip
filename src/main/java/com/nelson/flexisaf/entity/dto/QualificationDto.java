package com.nelson.flexisaf.entity.dto;

import com.nelson.flexisaf.entity.Qualification;
import com.nelson.flexisaf.entity.Qualification.QualificationType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class QualificationDto {

    private QualificationType qualificationType;

    private LocalDate dateIn;

    private Long employeeId;
}
