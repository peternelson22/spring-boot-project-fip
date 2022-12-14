package com.nelson.flexisaf.service;

import com.nelson.flexisaf.entity.Contact;
import com.nelson.flexisaf.dto.ContactDto;

public interface ContactService {

    void updateContactInfo(Long id, ContactDto contactDto);

    void saveContact(Long id, ContactDto contactDto);

    ContactDto getEmployeeContactDetails(String email);
}
