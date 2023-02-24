package com.bank.BankManagement.Service;
import com.bank.BankManagement.Entity.BankEntity;
import com.bank.BankManagement.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BankService {
    @Autowired
    private BankRepository repository;

    public BankEntity saveAccount(BankEntity account) {

        return repository.save(account);
    }
    public List<BankEntity> getAccounts(List<BankEntity> account) {

        return repository.saveAll(account);
    }
    public List<BankEntity> getAccounts() {
        return repository.findAll();
    }
    public BankEntity getAccountById(int accountNumber) {

        return repository.findById(accountNumber).orElse(null);
    }
    public String  deleteAccountById(int accountNumber) {
        repository.deleteById(accountNumber);
        return "Account- " + accountNumber + " is deleted";
    }
    public BankEntity updateAccount(BankEntity entity) {
        BankEntity existingAccount = repository.findById(entity.getAccountID()).orElse(null);
        existingAccount.setAccountType(entity.getAccountType());
        existingAccount.setCustomerID(entity.getCustomerID());
        existingAccount.setCustomerName(entity.getCustomerName());
        existingAccount.setAccountBalance(entity.getAccountBalance());
        existingAccount.setStatus(entity.getStatus());
        existingAccount.setInterest(entity.getInterest());
        return repository.save(existingAccount);
    }
}

