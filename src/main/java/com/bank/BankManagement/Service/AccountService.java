package com.bank.BankManagement.Service;
import com.bank.BankManagement.Entity.AccountEntity;
import com.bank.BankManagement.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<AccountEntity> createAccountForCustomer(AccountEntity account) {
        String customerUrl = "http://localhost:9090/customer/customerById/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //ResponseEntity<String> response = restTemplate.postForEntity(customerUrl, account, AccountEntity.class);
        //return repository.save(account);
        return restTemplate.postForEntity(customerUrl, account, AccountEntity.class);
    }
    public List<AccountEntity> addAccounts(List<AccountEntity> account) {
        return repository.saveAll(account);
    }
    public List<AccountEntity> getAccounts() {
        return repository.findAll();
    }
    public AccountEntity getAccountById(int accountNumber) {
        return repository.findById(accountNumber).orElse(null);
    }
    public String  deleteAccountById(int accountNumber) {
        repository.deleteById(accountNumber);
        return "Account- " + accountNumber + " is deleted";
    }
    public AccountEntity updateAccount(AccountEntity entity) {
        AccountEntity existingAccount = repository.findById(entity.getAccountID()).orElse(null);
        existingAccount.setAccountType(entity.getAccountType());
        existingAccount.setAccountBalance(entity.getAccountBalance());
        existingAccount.setStatus(entity.getStatus());
        existingAccount.setInterest(entity.getInterest());
        return repository.save(existingAccount);
    }
}

