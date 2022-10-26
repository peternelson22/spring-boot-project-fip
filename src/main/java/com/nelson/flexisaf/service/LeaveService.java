package com.nelson.flexisaf.service;

import com.nelson.flexisaf.dto.LeaveDto;

import java.util.List;

public interface LeaveService {

    void saveLeaveDetails(Long id, LeaveDto leaveDto);

    List<LeaveDto> getEmployeeLeaveDetails(String email);
}
