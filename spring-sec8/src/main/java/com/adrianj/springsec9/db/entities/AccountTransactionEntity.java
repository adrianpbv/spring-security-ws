package com.adrianj.springsec9.db.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "account_transactions")
public class AccountTransactionEntity {
    @Id
    @Column(name = "transaction_id", nullable = false, length = 200)
    private String transactionId;

    @Column(name = "account_number", nullable = false)
    private Integer accountNumber;

    @Column(name = "customer_id", nullable = false)
    private Integer customer;

    @Column(name = "transaction_dt", nullable = false)
    private LocalDate transactionDt;

    @Column(name = "transaction_summary", nullable = false, length = 200)
    private String transactionSummary;

    @Column(name = "transaction_type", nullable = false, length = 100)
    private String transactionType;

    @Column(name = "transaction_amt", nullable = false)
    private Integer transactionAmt;

    @Column(name = "closing_balance", nullable = false)
    private Integer closingBalance;

    @Column(name = "create_dt")
    private LocalDate createDt;

}