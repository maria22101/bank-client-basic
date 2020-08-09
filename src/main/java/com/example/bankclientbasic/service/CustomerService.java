package com.example.bankclientbasic.service;

import com.example.bankclientbasic.model.Customer;
import com.example.bankclientbasic.repository.CustomerDao;

import java.util.List;

public class CustomerService implements GeneralService<Customer>{

    private CustomerDao dao = new CustomerDao();

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
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Customer getById(long id) {
        return null;
    }
}
