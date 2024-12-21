package com.adrianj.springsec11.db.repositories;

import com.adrianj.springsec11.db.entities.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<LoanEntity, Integer> {
    List<LoanEntity> findByCustomerOrderByStartDtDesc(Integer customerId);
}
