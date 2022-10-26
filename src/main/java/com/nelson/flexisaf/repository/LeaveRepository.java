package com.nelson.flexisaf.repository;

import com.nelson.flexisaf.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
}
