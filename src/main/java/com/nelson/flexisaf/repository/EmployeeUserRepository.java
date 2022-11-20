package com.nelson.flexisaf.repository;

import com.nelson.flexisaf.entity.EmployeeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeUserRepository extends JpaRepository<EmployeeUser, Long> {

    Optional<EmployeeUser> findByUsername(String username);
}
