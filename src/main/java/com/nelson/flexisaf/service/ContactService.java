package com.nelson.flexisaf.service;

import com.nelson.flexisaf.entity.Contact;
import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.entity.dto.ContactDto;

import java.util.List;

public interface ContactService {

    List<Contact> getContact();

    Contact updateContactInfo(Long id, Contact contact);

    void saveContact(Long id, ContactDto contactDto);
}
