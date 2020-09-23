package com.example.bankclientbasic.controller;

import com.example.bankclientbasic.dto.AccountResponseDto;
import com.example.bankclientbasic.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PutMapping("/{number}/add")
    public AccountResponseDto addSumToAccountByNumber(@PathVariable String number,
                                                      @RequestParam double sum) {
        return service.addSumToAccountNumber(number, sum);
    }

    @PutMapping("/{number}/withdraw")
    public AccountResponseDto withdrawSumFromAccountByNumber(@PathVariable String number,
                                                             @RequestParam double sum) {
        return service.withdrawSumFromAccountByNumber(number, sum);
    }

    @PutMapping("/{number}/{numberTo}/transfer")
    public void transferBetweenAccounts(@PathVariable (value = "number") String accountNumberFrom,
                                        @PathVariable (value = "numberTo") String accountNumberTo,
                                        @RequestParam double sum) {
        service.transferBetweenAccounts(accountNumberFrom, accountNumberTo, sum);
    }
}

