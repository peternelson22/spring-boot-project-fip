package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.entity.Contact;
import com.nelson.flexisaf.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@AllArgsConstructor
public class ContactController {

    private ContactService contactService;

    @PostMapping("/save")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact){
        return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact){
        return new ResponseEntity<>(contactService.updateContact(id, contact), HttpStatus.CREATED);
    }

}
