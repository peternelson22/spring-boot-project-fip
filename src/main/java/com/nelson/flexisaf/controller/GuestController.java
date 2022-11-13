package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.dto.GuestDto;
import com.nelson.flexisaf.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GuestController {

    private GuestService guestService;

    @PostMapping("/guests/{id}")
    public ResponseEntity<String> saveGuests(@PathVariable Long id, @RequestBody GuestDto guestDto){
        guestService.saveGuests(id, guestDto);
        return ResponseEntity.ok("Successful");
    }

    @GetMapping("/guests/{name}")
    public ResponseEntity<List<GuestDto>> getGuestLogs(@PathVariable String name){
        return ResponseEntity.ok(guestService.getGuestLogs(name));

    }
}
