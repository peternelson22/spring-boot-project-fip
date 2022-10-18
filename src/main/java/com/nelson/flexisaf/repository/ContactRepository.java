package com.nelson.flexisaf.repository;

import com.nelson.flexisaf.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
