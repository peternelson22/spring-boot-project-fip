package com.nelson.flexisaf.service;

import com.nelson.flexisaf.dto.DependentDto;

import java.util.List;

public interface DependentService {

    void saveDependent(Long id, DependentDto dependentDto);

    void updateDependentInfo(Long id, DependentDto dependentDto);

    List<DependentDto> getEmployeeDependentDetails(String email);
}
