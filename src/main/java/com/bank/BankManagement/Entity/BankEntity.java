package com.bank.BankManagement.Entity;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "accountTable")
public class BankEntity {
    @Id
    @GeneratedValue
    @Column(name = "accountID")
    private int accountID;
    @Column(name = "account_balance")
    private int accountBalance;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "customerid")
    private int customerID;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "interest")
    private float interest;
    @Column(name = "status")
    private String status;
}
