package com.nelson.flexisaf.repository;

import com.nelson.flexisaf.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    List<Employee> findByFirstNameIgnoreCase(String firstName);

    List<Employee> findByFirstNameContaining(String name, Sort sort);

    Employee findByEmail(String email);

    //JPQL QUERY - REFERENCES THE OBJECT CLASS NAME RATHER THAN THE TABLE's NAME
    @Query("SELECT e.firstName, e.lastName FROM Employee e WHERE e.email = :email")
    String getEmployeeFirstNameAndLastNameByEmail(String email);

    //Join query
    List<Employee> findByDepartmentNameContaining(String name);

}
