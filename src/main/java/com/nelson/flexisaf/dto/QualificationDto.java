package com.nelson.flexisaf.dto;

import com.nelson.flexisaf.entity.Qualification;
import com.nelson.flexisaf.entity.Qualification.QualificationType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class QualificationDto {

    private QualificationType qualificationType;

    private LocalDate dateIn;

    private Long employeeId;
}
