package com.bank.BankManagement.Controller;
import com.bank.BankManagement.CustomerNotFoundException;
import com.bank.BankManagement.Entity.AccountEntity;
import com.bank.BankManagement.Service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
//import java.util.logging.Logger;

@RestController
@RequestMapping("/account")
public class AccountController {
    private static final Logger logger = Logger.getLogger(String.valueOf(AccountController.class));

     RestTemplate restTemplate=new RestTemplate();
    @Autowired
    private AccountService service;
    @Autowired
    private AccountEntity entity;
    @PostMapping(value="/addAccount")
    public ResponseEntity<AccountEntity> createAccountForCustomer(@RequestBody AccountEntity account) {
//        int customerId= entity.getCustomerId();
//        if (customerId) {
//            new CustomerNotFoundException("Customer with ID " + customerId + " not found");
//        }
//        AccountEntity entity = service.createAccountForCustomer(customer);
        return service.createAccountForCustomer(account);
    }

    @PostMapping("/addAccounts")
    //Adding Multiple Account Details
    public List<AccountEntity> addAccounts(@RequestBody List<AccountEntity> entities) {
        logger.info("Multiple Account Added ");
        return service.addAccounts(entities);
    }

    @GetMapping("/accounts")
    public List<AccountEntity> findAllAccount() {
        logger.info("Getting All Accounts "+service.getAccounts());
        return service.getAccounts();
    }
    @GetMapping("/accountByNumber/{accountNumber}")
    public AccountEntity findAccountById(@PathVariable int accountNumber) {
        logger.info("Get Account Details by AccountNumber "+accountNumber);
        return service.getAccountById(accountNumber);
    }

    @RequestMapping(value = "/template/customer")
    public String getCustomerList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                "http://localhost:9090/customer/allcustomers", HttpMethod.GET, entity, String.class).getBody();
    }

    //        @GetMapping("/accountByName/{customerName}")
//        public List<BankEntity> findAccountByName(@PathVariable String customerName) {
//            return service.getAccountByName(customerName);
//        }
    @PutMapping("/updateAccount")
    public AccountEntity updateAccount(@RequestBody AccountEntity entity) {
        logger.info("Account Updated Successfully "+entity);
        return service.updateAccount(entity);
    }
    @DeleteMapping("/deleteAccount/{accountNumber}")
    public String deleteAccountById(@PathVariable int accountNumber) {
        logger.info("Account Deleted Successfuly "+accountNumber);
        String s = service.deleteAccountById(accountNumber);
        //return service.deleteAccountById(accountNumber);
        return "Account Deleted"+s;
    }
}
