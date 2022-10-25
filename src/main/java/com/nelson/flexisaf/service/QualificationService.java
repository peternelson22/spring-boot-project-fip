package com.nelson.flexisaf.service;

import com.nelson.flexisaf.dto.QualificationDto;

public interface QualificationService {

    void saveQualification(Long id, QualificationDto qualificationDto);
}
