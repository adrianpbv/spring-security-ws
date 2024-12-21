package com.adrianj.springsec11.controllers;

import com.adrianj.springsec11.db.entities.AccountTransactionEntity;
import com.adrianj.springsec11.db.repositories.AccountTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final AccountTransactionRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactionEntity> getBalanceDetails(@RequestParam Integer id) {
        List<AccountTransactionEntity> accountTransactions = accountTransactionsRepository.
                findByCustomerOrderByTransactionDtDesc(id);
        if (!accountTransactions.isEmpty()) {
            return accountTransactions;
        } else {
            return null;
        }
    }
}
