package com.nelson.flexisaf.repository;

import com.nelson.flexisaf.entity.EmployeeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeUserRepository extends JpaRepository<EmployeeUser, Long> {
}
