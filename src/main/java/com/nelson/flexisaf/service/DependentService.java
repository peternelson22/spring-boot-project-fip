package com.nelson.flexisaf.service;

import com.nelson.flexisaf.dto.DependentDto;

public interface DependentService {

    void saveDependent(Long id, DependentDto dependentDto);

    void updateDependentInfo(Long id, DependentDto dependentDto);

    DependentDto getEmployeeDependentDetails(String email);
}
