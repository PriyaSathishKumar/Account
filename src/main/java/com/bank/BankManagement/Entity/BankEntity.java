package com.bank.BankManagement.Entity;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "accountTable")
public class BankEntity {
    @Id
    @GeneratedValue
    private int accountNumber;
    private int accountBalance;
    private String accountType;
    private int customerID;
    private String customerName;
    private float interest;
    private String status;



}
