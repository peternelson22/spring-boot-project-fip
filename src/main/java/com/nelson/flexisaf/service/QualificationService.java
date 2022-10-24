package com.nelson.flexisaf.service;

import com.nelson.flexisaf.entity.Qualification;
import com.nelson.flexisaf.entity.dto.QualificationDto;

public interface QualificationService {

    void saveQualification(Long id, QualificationDto qualificationDto);
}
