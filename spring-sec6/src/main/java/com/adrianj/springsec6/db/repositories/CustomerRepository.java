package com.adrianj.springsec6.db.repositories;

import com.adrianj.springsec6.db.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    Optional<CustomerEntity> findByEmail(String email);
}
