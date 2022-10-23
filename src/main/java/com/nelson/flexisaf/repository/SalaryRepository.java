package com.nelson.flexisaf.repository;

import com.nelson.flexisaf.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
