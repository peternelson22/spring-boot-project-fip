package com.nelson.flexisaf.repository;

import com.nelson.flexisaf.entity.GuestLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<GuestLog, Long> {


}
