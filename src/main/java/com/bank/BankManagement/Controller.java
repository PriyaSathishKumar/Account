package com.bank.BankManagement;
import com.bank.BankManagement.Entity.BankEntity;
import com.bank.BankManagement.Service.BankService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
//import java.util.logging.Logger;

@RestController
@RequestMapping("/bank")
public class Controller {
    private static final Logger logger = Logger.getLogger(String.valueOf(Controller.class));

    @Autowired
    private BankService service;
    @PostMapping("/addAccount")
    //Adding New Account Details
    public BankEntity addAccount(@RequestBody BankEntity entity) {
        logger.info("Account Added Msg ");
        logger.info("Priya");
        return service.saveAccount(entity);
    }
    @PostMapping("/addAccounts")
    //Adding Multiple Account Details
    public List<BankEntity> addAccounts(@RequestBody List<BankEntity> entities) {
        logger.info("Multiple Account Added ");
        return service.getAccounts(entities);
    }
    @GetMapping("/accounts")
    public List<BankEntity> findAllAccount() {
        logger.info("Getting All Accounts "+service.getAccounts());
        return service.getAccounts();
    }
    @GetMapping("/accountByNumber/{accountNumber}")
    public BankEntity findAccountById(@PathVariable int accountNumber) {
        logger.info("Get Account Details by AccountNumber "+accountNumber);
        return service.getAccountById(accountNumber);
    }
    @Autowired
    RestTemplate restTemplate;
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
    public BankEntity updateAccount(@RequestBody BankEntity entity) {
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
