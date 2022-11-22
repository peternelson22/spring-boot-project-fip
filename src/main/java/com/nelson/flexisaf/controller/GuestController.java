package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.dto.GuestDto;
import com.nelson.flexisaf.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/guests")
public class GuestController {

    private GuestService guestService;

    @PostMapping("{id}")
    public ResponseEntity<String> saveGuests(@PathVariable Long id, @RequestBody GuestDto guestDto){
        guestService.saveGuests(id, guestDto);
        return ResponseEntity.ok("Successful");
    }

    @GetMapping("{name}")
    public ResponseEntity<List<GuestDto>> getGuestLogs(@PathVariable String name){
        return ResponseEntity.ok(guestService.getGuestLogs(name));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGuestLogs(@PathVariable Long id){
        guestService.deleteGuestLogs(id);
        return ResponseEntity.ok("Successfully deleted");

    }
}
