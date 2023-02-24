package com.bank.BankManagement;

import com.bank.BankManagement.Entity.BankEntity;
import com.bank.BankManagement.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/bank")
public class Controller {
    @Autowired

    private BankService service;

    @PostMapping("/addAccount")
    public BankEntity addAccount(@RequestBody BankEntity entity) {
        return service.saveAccount(entity);
    }

    @PostMapping("/addAccounts")
    public List<BankEntity> addAccounts(@RequestBody List<BankEntity> entities) {
        return service.saveAccount(entities);
    }

    @GetMapping("/accounts")
    public List<BankEntity> findAllAccount() {
        //System.out.println("test students");
        return service.getAccounts();
    }

    @GetMapping("/accountByNumber/{accountNumber}")
    public BankEntity findAccountById(@PathVariable int accountNumber) {

        return service.getAccountById(accountNumber);
    }

    //    @GetMapping("/accountByName/{customerName}")
//    public List<BankEntity> findAccountByName(@PathVariable String customerName) {
//        return service.getAccountByName(customerName);
//    }
    @PutMapping("/updateAccount")
    public BankEntity updateAccount(@RequestBody BankEntity entity) {

        return service.updateAccount(entity);
    }

    @DeleteMapping("/deleteAccount/{accountNumber}")
    public String deleteAccountById(@PathVariable int accountNumber) {
        String s = BankService.deleteBankEntityById(accountNumber);
        return s;
        //return "Account Deleted"+s;
    }

}
