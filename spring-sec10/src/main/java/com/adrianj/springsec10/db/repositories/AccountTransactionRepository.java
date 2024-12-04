package com.adrianj.springsec10.db.repositories;

import com.adrianj.springsec10.db.entities.AccountTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionRepository extends JpaRepository<AccountTransactionEntity, Integer> {
    List<AccountTransactionEntity> findByCustomerOrderByTransactionDtDesc(Integer customerId);
}
