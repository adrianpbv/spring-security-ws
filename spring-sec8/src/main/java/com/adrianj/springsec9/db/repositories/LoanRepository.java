package com.adrianj.springsec9.db.repositories;

import com.adrianj.springsec9.db.entities.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<LoanEntity, Integer> {
    List<LoanEntity> findByCustomerOrderByStartDtDesc(Integer customerId);
}
