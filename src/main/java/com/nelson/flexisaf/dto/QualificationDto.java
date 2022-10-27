package com.nelson.flexisaf.dto;

import com.nelson.flexisaf.entity.Qualification;
import com.nelson.flexisaf.entity.Qualification.QualificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QualificationDto {

    private QualificationType qualificationType;

    private LocalDate dateIn;

}
