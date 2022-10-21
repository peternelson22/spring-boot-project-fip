package com.nelson.flexisaf.repository;

import com.nelson.flexisaf.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
