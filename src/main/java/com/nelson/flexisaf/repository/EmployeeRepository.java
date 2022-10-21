package com.nelson.flexisaf.repository;

import com.nelson.flexisaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstNameIgnoreCase(String firstName);

    List<Employee> findByFirstNameContaining(String name);

    Employee findByEmail(String email);


}
