package com.example.bankclientbasic.service;

import com.example.bankclientbasic.model.Account;
import com.example.bankclientbasic.repository.AccountDao;

import java.util.List;

public class AccountService implements GeneralService<Account>{

    private AccountDao dao = new AccountDao();

    @Override
    public Account save(Account obj) {
        return null;
    }

    @Override
    public boolean delete(Account obj) {
        return false;
    }

    @Override
    public void deleteAll(List<Account> entities) {

    }

    @Override
    public void saveAll(List<Account> entities) {

    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Account getById(long id) {
        return null;
    }
}
