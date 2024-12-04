package com.adrianj.springsec10.db.repositories;

import com.adrianj.springsec10.db.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<CardEntity, Integer> {
    List<CardEntity> findByCustomer(Integer customerId);
}
