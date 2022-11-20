package com.nelson.flexisaf.service.impl;

import com.nelson.flexisaf.config.JwtProvider;
import com.nelson.flexisaf.dto.AuthenticationResponse;
import com.nelson.flexisaf.dto.LoginRequest;
import com.nelson.flexisaf.dto.RegisterRequest;
import com.nelson.flexisaf.entity.EmployeeUser;
import com.nelson.flexisaf.entity.Role;
import com.nelson.flexisaf.repository.EmployeeUserRepository;
import com.nelson.flexisaf.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthService {


    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeUserRepository userRepository;
    private final RoleRepository roleRepository;


    @Transactional
    public void signup(RegisterRequest registerRequest) {
        EmployeeUser user = new EmployeeUser();
        Role role = new Role();

        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreatedAt(LocalDate.now());

        role.setRoleName("ROLE_USER");
        user.setRole(Set.of(role));

        userRepository.save(user);
        roleRepository.save(role);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtProvider.generateToken(authenticate);
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(loginRequest.getUsername())
                .build();
    }

    @Transactional(readOnly = true)
    public EmployeeUser getCurrentUser() {
        Jwt principal = (Jwt) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(principal.getSubject())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getSubject()));
    }}
