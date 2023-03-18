package com.bank.BankManagement;

import com.bank.BankManagement.Controller.AccountController;
import com.bank.BankManagement.Entity.AccountEntity;
import com.bank.BankManagement.Repository.AccountRepository;
import com.bank.BankManagement.Service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@WebMvcTest(AccountController.class)
public class AccountControllerTest {
       @MockBean
        private AccountRepository accountRepository;
       @Autowired
       private AccountService accountService;
       @Autowired
       private MockMvc mockMvc;
       @Autowired
       private ObjectMapper objectMapper;
       @BeforeEach
       public void testAccountById()throws Exception{
           AccountEntity mockAccount=new AccountEntity();
           mockAccount.setAccountID(12);
           mockAccount.setAccountType("Savings");
           mockAccount.setAccountBalance(5000);
           mockAccount.setCustomerId(1);
           //mockAccount.setCustomerName("AAA");
           mockAccount.setInterest(3.0F);
           mockAccount.setStatus("Active");

           int accountId=12;
           //Optional<AccountEntity>
           when(accountService.getAccountById(12)).thenReturn(mockAccount);
           RequestBuilder requestBuilder = null;
           ResultActions response= mockMvc.perform((RequestBuilder) get("/account/accountByNumber/"+accountId));
           response.andExpect(status().isOk())
                   .andDo(print())
                   .andExpect((ResultMatcher) jsonPath("$.accountBalance",is(mockAccount.getAccountBalance())));
       }
}
