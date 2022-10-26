package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Contact;
import com.nelson.flexisaf.entity.Employee;
import com.nelson.flexisaf.dto.ContactDto;
import com.nelson.flexisaf.exception.ResourceNotFoundException;
import com.nelson.flexisaf.repository.ContactRepository;
import com.nelson.flexisaf.repository.EmployeeRepository;
import com.nelson.flexisaf.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;
    private EmployeeRepository employeeRepository;


    @Override
    public void updateContactInfo(Long id, Contact contact) {
        Contact existingContact = contactRepository.findById(id).orElseThrow(() -> new IllegalStateException("Not found"));
        existingContact.setPhoneMobile(contact.getPhoneMobile());
        existingContact.setPhoneHome(contact.getPhoneHome());
        existingContact.setNextOfKinMobile(contact.getNextOfKinMobile());
        existingContact.setAddress(contact.getAddress());
        contactRepository.save(existingContact);
    }

    @Override
    public void saveContact(Long id, ContactDto contactDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee with id " + id + " does not exist"));

        Contact contact = Contact.builder()
                .address(contactDto.getAddress())
                .phoneHome(contactDto.getPhoneHome())
                .phoneMobile(contactDto.getPhoneMobile())
                .nextOfKinMobile(contactDto.getNextOfKinMobile())
                .employee(employee)
                .build();

        contactRepository.save(contact);

    }

    @Override
    public ContactDto getEmployeeContactDetails(String email) {
        Optional<Employee> e = employeeRepository.findByEmail(email);
        if (!e.isPresent())
            throw new ResourceNotFoundException("No employee found with email " + email);

        Contact contact = new Contact();
        ContactDto contactDto = ContactDto.builder()
                .name(contact.getEmployee().getFirstName() + " " + contact.getEmployee().getLastName())
                .address(contact.getAddress())
                .phoneMobile(contact.getPhoneMobile())
                .phoneHome(contact.getPhoneHome())
                .email(contact.getEmployee().getEmail())
                .nextOfKinMobile(contact.getNextOfKinMobile())
                .build();

        return contactDto;
    }


}
