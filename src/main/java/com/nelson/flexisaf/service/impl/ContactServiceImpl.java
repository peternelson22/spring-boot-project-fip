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
    public void updateContactInfo(Long id, ContactDto contactDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee with id " + id + " does not exist"));

        Contact contact = contactRepository.findById(id).get();

        contact.setAddress(contactDto.getAddress());
        contact.setPhoneMobile(contactDto.getPhoneMobile());
        contact.setNextOfKinMobile(contactDto.getNextOfKinMobile());
        contact.setPhoneHome(contactDto.getPhoneHome());
        contact.setEmployee(employee);

        contactRepository.save(contact);
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
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null)
            throw new ResourceNotFoundException("No employee found with email " + email);

        ContactDto contactDto = new ContactDto();
        contactDto.setAddress(employee.getContact().getAddress());
        contactDto.setPhoneHome(employee.getContact().getPhoneHome());
        contactDto.setEmail(employee.getEmail());
        contactDto.setNextOfKinMobile(employee.getContact().getNextOfKinMobile());
        contactDto.setName(employee.getFirstName() + " " + employee.getLastName());

        return contactDto;
    }


}
