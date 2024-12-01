package com.adrianj.springsec9.db.repositories;

import com.adrianj.springsec9.db.entities.ContactMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactMessageEntity, String> {
}
