package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.entity.Contact;
import com.nelson.flexisaf.dto.ContactDto;
import com.nelson.flexisaf.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/contact")
public class ContactController {

    private ContactService contactService;

    @PostMapping("/save/{id}")
    public ResponseEntity<String> saveContacts(@PathVariable Long id, @RequestBody ContactDto contactDto){
        contactService.saveContact(id, contactDto);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateContact(@PathVariable Long id, @RequestBody Contact contact){
        contactService.updateContactInfo(id, contact);
        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }

    @GetMapping("/details/{email}")
    public ResponseEntity<ContactDto> getEmployeeContactDetails(@PathVariable String email){
        return ResponseEntity.ok(contactService.getEmployeeContactDetails(email));
    }
}
