package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.entity.Contact;
import com.nelson.flexisaf.repository.ContactRepository;
import com.nelson.flexisaf.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        Contact existingContact = contactRepository.findById(id).get();
        
        existingContact.setAddress(contact.getAddress());
        existingContact.setPhoneHome(contact.getPhoneHome());
        existingContact.setPhoneMobile(contact.getPhoneMobile());
        existingContact.setNextOfKinMobile(contact.getNextOfKinMobile());

        return contactRepository.save(existingContact);
    }
}
