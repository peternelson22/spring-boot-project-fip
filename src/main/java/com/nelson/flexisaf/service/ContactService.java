package com.nelson.flexisaf.service;

import com.nelson.flexisaf.entity.Contact;

public interface ContactService {

    Contact saveContact(Contact contact);

    Contact updateContact(Long id, Contact contact);
}
