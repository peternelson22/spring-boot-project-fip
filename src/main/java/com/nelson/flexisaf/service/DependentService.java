package com.nelson.flexisaf.service;

import com.nelson.flexisaf.entity.Dependent;
import com.nelson.flexisaf.entity.dto.DependentDto;

public interface DependentService {

    void saveDependent(Long id, DependentDto dependentDto);
}
