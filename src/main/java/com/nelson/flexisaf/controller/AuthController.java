package com.nelson.flexisaf.controller;

import com.nelson.flexisaf.dto.AuthenticationResponse;
import com.nelson.flexisaf.dto.LoginRequest;
import com.nelson.flexisaf.dto.RegisterRequest;
import com.nelson.flexisaf.entity.EmployeeUser;
import com.nelson.flexisaf.service.impl.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful", OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @GetMapping("{username}")
    public ResponseEntity<EmployeeUser> getCurrentUser(@PathVariable String username){
        return new ResponseEntity<>(authService.getCurrentUser(username), OK);

    }
}
