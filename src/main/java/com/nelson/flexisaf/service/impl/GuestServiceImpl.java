package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.dto.GuestDto;
import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.GuestLog;
import com.nelson.flexisaf.exception.ResourceNotFoundException;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.repository.GuestRepository;
import com.nelson.flexisaf.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {

    private GuestRepository guestRepository;
    private EmployeeRepository employeeRepository;

    @Override
    public void saveGuests(Long id, GuestDto guestDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee with " + id + " does not exit"));

        GuestLog guestLog = GuestLog.builder()
                .description(guestDto.getDescription())
                .date(LocalDate.now())
                .employees(List.of(employee))
                .visitorName(guestDto.getName())
                .build();

        guestRepository.save(guestLog);
    }

    @Override
    public List<GuestDto> getGuestLogs(String name) {
        List<GuestDto> list = new ArrayList<>();
        List<Employee> employee = employeeRepository.findByFirstNameIgnoreCase(name);

        if (employee == null){
            throw new ResourceNotFoundException("Employee with " + name + " does not exit");
        }

        List<GuestLog> guestLogs = guestRepository.findAll();
        guestLogs.forEach(g -> {
            GuestDto guestDto = GuestDto.builder()
                    .description(g.getDescription())
                    .date(LocalDate.now())
                    .name(g.getVisitorName())
                    .build();

            list.add(guestDto);
        } );
        return list;
    }
}
