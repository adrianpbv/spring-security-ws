package com.adrianj.springsec11.controllers;

import com.adrianj.springsec11.db.entities.AccountEntity;
import com.adrianj.springsec11.db.repositories.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountsRepository accountsRepository;

    @GetMapping("/myAccount")
    public List<AccountEntity> getAccountDetails(@RequestParam Integer id) {
        List<AccountEntity> accounts = accountsRepository.findByCustomer(id);
        if (!accounts.isEmpty()) {
            return accounts;
        } else {
            return null;
        }
    }

}
