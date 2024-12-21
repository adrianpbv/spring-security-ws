package com.adrianj.springsec11.db.repositories;

import com.adrianj.springsec11.db.entities.ContactMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactMessageEntity, String> {
}
