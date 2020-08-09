package com.example.bankclientbasic.controller;

import com.example.bankclientbasic.model.Customer;
import com.example.bankclientbasic.service.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService service = new CustomerService();

    public Customer getCustomerInfoById(int id) {
        return null;
    }

    public List<Customer> getAllCustomersInfo() {
        return null;
    }

    public void createCustomer() {

    }

    public void updateCustomerById(int id) {

    }

    public void deleteCustomerById(int id) {

    }

    public void createAccountForCustomerById(int id) {

    }

    public void closeAccountOfCustomerById(String accountNumberToClose, int id) {

    }
}
