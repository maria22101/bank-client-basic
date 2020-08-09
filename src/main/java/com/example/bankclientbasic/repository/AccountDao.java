package com.example.bankclientbasic.repository;

import com.example.bankclientbasic.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDao implements GeneralDao<AccountDao>{

    List<Account> storage = new ArrayList<>();

    @Override
    public AccountDao save(AccountDao obj) {
        return null;
    }

    @Override
    public boolean delete(AccountDao obj) {
        return false;
    }

    @Override
    public void deleteAll(List<AccountDao> entities) {

    }

    @Override
    public void saveAll(List<AccountDao> entities) {

    }

    @Override
    public List<AccountDao> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public AccountDao getOne(long id) {
        return null;
    }
}
