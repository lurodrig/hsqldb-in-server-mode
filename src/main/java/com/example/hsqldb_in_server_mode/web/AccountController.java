package com.example.hsqldb_in_server_mode.web;

import com.example.hsqldb_in_server_mode.business.Account;
import com.example.hsqldb_in_server_mode.business.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }
}
