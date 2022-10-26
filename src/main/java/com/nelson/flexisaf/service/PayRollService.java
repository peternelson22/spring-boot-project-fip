package com.nelson.flexisaf.service;

import com.nelson.flexisaf.dto.PayRollDto;
import com.nelson.flexisaf.entity.PayRoll;

import java.util.List;

public interface PayRollService {

    List<PayRollDto> getEmployeesPayRollDetails(String email);
}
