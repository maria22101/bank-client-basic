package com.example.bankclientbasic.controller;

import com.example.bankclientbasic.service.AccountService;

public class AccountController {

    private AccountService service = new AccountService();

    public void replenishAccountByNumber(String accountNumber, Double sum) {

    }

    public void withdrawSumFromAccountByNumber(String accountNumber, Double sum) {

    }

    public void transferBetweenAccounts(String accountNumberFrom,
                                        String accountNumberTo,
                                        Double sum) {

    }
}
