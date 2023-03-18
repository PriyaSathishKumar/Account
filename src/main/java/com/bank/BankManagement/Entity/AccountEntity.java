package com.bank.BankManagement.Entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "accountTable")
public class AccountEntity {
    @Id
    @GeneratedValue
    @Column(name = "accountID")
    private int accountID;
    @Column(name = "customerID")
    private int customerId;
    @Column(name = "account_balance")
    private int accountBalance;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "interest")
    private float interest;
    @Column(name = "status")
    private String status;
}
