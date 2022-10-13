package com.nelson.flexisaf.repository;

import com.nelson.flexisaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByFirstName(String name);
}
