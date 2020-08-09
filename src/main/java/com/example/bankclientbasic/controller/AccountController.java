package com.example.bankclientbasic.controller;

import com.example.bankclientbasic.model.Account;
import com.example.bankclientbasic.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/v1/accounts")
public class AccountController {

    private final AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @PutMapping("/{number}/add")
    public Account addSumToAccountByNumber(@PathVariable String number,
                                            @RequestParam double sum) {
        return service.addSum(number, sum);
    }

    @PutMapping("/{number}/withdraw")
    public Account withdrawSumFromAccountByNumber(@PathVariable String number,
                                                  @RequestParam double sum) {
        return service.withdrawSum(number, sum);
    }

    @PutMapping("/{number}/{numberTo}/transfer")
    public void transferBetweenAccounts(@PathVariable (value = "number") String accountNumberFrom,
                                        @PathVariable (value = "numberTo") String accountNumberTo,
                                        @RequestParam double sum) {
        service.transferBetweenAccounts(accountNumberFrom, accountNumberTo, sum);
    }
}
