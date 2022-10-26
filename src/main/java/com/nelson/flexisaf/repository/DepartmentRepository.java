package com.nelson.flexisaf.repository;

import com.nelson.flexisaf.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Department WHERE id = :id")
    void deleteById (Long id);


}
