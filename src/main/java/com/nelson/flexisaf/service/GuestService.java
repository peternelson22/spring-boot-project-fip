package com.nelson.flexisaf.service;

import com.nelson.flexisaf.dto.GuestDto;

import java.util.List;

public interface GuestService {

    void saveGuests(Long id, GuestDto guestDto);

    List<GuestDto> getGuestLogs(String name);

    void deleteGuestLogs(Long id);
}
