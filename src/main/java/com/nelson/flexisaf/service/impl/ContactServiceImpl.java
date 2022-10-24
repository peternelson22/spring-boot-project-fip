package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Contact;
import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.entity.dto.ContactDto;
import com.nelson.flexisaf.repository.ContactRepository;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;
    private EmployeeRepository employeeRepository;


    @Override
    public Contact updateContactInfo(Long id, Contact contact) {
        Contact existingContact = contactRepository.findById(id).orElseThrow(() -> new IllegalStateException("Not found"));
        existingContact.setPhoneMobile(contact.getPhoneMobile());
        existingContact.setPhoneHome(contact.getPhoneHome());
        existingContact.setNextOfKinMobile(contact.getNextOfKinMobile());
        existingContact.setAddress(contact.getAddress());
        return contactRepository.save(existingContact);
    }

    @Override
    public void saveContact(Long id, ContactDto contactDto) {
        Employee employee = employeeRepository.findById(id).get();

        Contact contact = new Contact();
        contact.setAddress(contactDto.getAddress());
        contact.setPhoneHome(contactDto.getPhoneHome());
        contact.setPhoneMobile(contactDto.getPhoneMobile());
        contact.setNextOfKinMobile(contactDto.getNextOfKinMobile());
        contact.setEmployee(employee);

        contactRepository.save(contact);

    }


}
