package com.adrianj.springsec10.db.repositories;

import com.adrianj.springsec10.db.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountsRepository extends JpaRepository<AccountEntity, Integer> {
    List<AccountEntity> findByCustomer(Integer customerId);
}
