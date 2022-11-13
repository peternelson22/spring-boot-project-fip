package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.dto.LeaveDto;
import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.Leave;
import com.nelson.flexisaf.exception.ResourceNotFoundException;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.repository.LeaveRepository;
import com.nelson.flexisaf.service.LeaveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LeaveServiceImpl implements LeaveService {

    private LeaveRepository leaveRepository;

    private EmployeeRepository employeeRepository;

    @Override
    public void saveLeaveDetails(Long id, LeaveDto leaveDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee with id " + id + "does not exist"));

        Leave leave = Leave.builder()
                .dateOfLeave(OffsetDateTime.now().toLocalDate())
                .weeksSpent(leaveDto.getWeeksToSpend())
                .employee(employee)
                .build();

        LocalDate currentDate = leave.getDateOfLeave().plusWeeks(leaveDto.getWeeksToSpend());
        leave.setEndDate(LocalDate.from(currentDate));

        leaveRepository.save(leave);
    }

    @Override
    public List<LeaveDto> getEmployeeLeaveDetails(String email) {
        List<LeaveDto> list = new ArrayList<>();
        Employee employee = employeeRepository.findByEmail(email);

        if (employee == null) {
            throw new ResourceNotFoundException("Employee not found");
        }
        List<Leave> leave = leaveRepository.findAll();
        leave.forEach(e -> {
            LeaveDto leaveDto = LeaveDto.builder()
                    .dateOfLeave(e.getDateOfLeave())
                    .endDate(e.getEndDate())
                    .weeksToSpend(e.getWeeksSpent())
                    .employee(e.getEmployee().getFirstName() + " " + e.getEmployee().getLastName())
                    .build();
            list.add(leaveDto);
        });

        return list;
    }


}
