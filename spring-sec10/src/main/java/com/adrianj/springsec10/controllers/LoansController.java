package com.adrianj.springsec10.controllers;

import com.adrianj.springsec10.db.entities.LoanEntity;
import com.adrianj.springsec10.db.repositories.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<LoanEntity> getLoanDetails(@RequestParam Integer id) {
        List<LoanEntity> loans = loanRepository.findByCustomerOrderByStartDtDesc(id);
        if (!loans.isEmpty()) {
            return loans;
        } else {
            return null;
        }
    }

}
