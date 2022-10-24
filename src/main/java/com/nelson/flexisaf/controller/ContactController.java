package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.entity.Contact;
import com.nelson.flexisaf.entity.Department;
import com.nelson.flexisaf.entity.dto.ContactDto;
import com.nelson.flexisaf.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactService;

    @PostMapping("/save/{id}")
    public ResponseEntity<HttpStatus> saveContacts(@PathVariable Long id, @RequestBody ContactDto contactDto){
        contactService.saveContact(id, contactDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact){
        return new ResponseEntity<>(contactService.updateContactInfo(id, contact), HttpStatus.CREATED);
    }
}
