package com.nelson.flexisaf.repository;

import com.nelson.flexisaf.entity.Employee;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    List<Employee> findByFirstNameContaining(String name, Sort sort);

    Employee findByEmail(String email);

    List<Employee> findByFirstNameIgnoreCase(String name);

    //JPQL QUERY - REFERENCES THE OBJECT CLASS NAME RATHER THAN THE TABLE's NAME
    @Query("SELECT e.firstName, e.lastName FROM Employee e WHERE e.email = :email")
    String getEmployeeFirstNameAndLastNameByEmail(String email);
    
    /* @Transactional
    @Modifying
    @Query("DELETE FROM Employee WHERE email = :email")
    Integer deleteByEmailAddress (String email);

    @Transactional
    @Modifying
    @Query("UPDATE Employee SET firstName = :firstName WHERE id = :id")
    Integer updateFirstNameById (Long id, String firstName);

    // NATIVE SQL QUERY - REFERENCES THE TABLE IN DB
    @Query(value = "SELECT * FROM employees  WHERE first_name = ?1 OR email = ?2", nativeQuery = true)
    Employee getEmployeeByEmailOrFirstName(String keyword);

    //Join query using JPA Specification
    List<Employee> findByDepartmentNameContaining(String name);
    */
}
