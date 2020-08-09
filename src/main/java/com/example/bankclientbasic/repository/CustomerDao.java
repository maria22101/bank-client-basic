package com.example.bankclientbasic.repository;

import com.example.bankclientbasic.model.Account;
import com.example.bankclientbasic.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements GeneralDao<Customer>{

    List<Account> storage = new ArrayList<>();

    @Override
    public Customer save(Customer obj) {
        return null;
    }

    @Override
    public boolean delete(Customer obj) {
        return false;
    }

    @Override
    public void deleteAll(List<Customer> entities) {

    }

    @Override
    public void saveAll(List<Customer> entities) {

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Customer getOne(long id) {
        return null;
    }
}
