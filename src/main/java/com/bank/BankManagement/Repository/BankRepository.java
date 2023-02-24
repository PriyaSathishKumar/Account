package com.bank.BankManagement.Repository;

import com.bank.BankManagement.Entity.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository  extends JpaRepository<BankEntity, Integer> {
}
