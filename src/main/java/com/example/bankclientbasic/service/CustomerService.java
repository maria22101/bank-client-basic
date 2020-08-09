package com.example.bankclientbasic.service;

import com.example.bankclientbasic.model.Account;
import com.example.bankclientbasic.model.Currency;
import com.example.bankclientbasic.model.Customer;
import com.example.bankclientbasic.repository.AccountDao;
import com.example.bankclientbasic.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements GeneralService<Customer>{

    private final CustomerDao customerDao;
    private final AccountDao accountDao;

    @Autowired
    public CustomerService(CustomerDao customerDao,
                           AccountDao accountDao) {
        this.customerDao = customerDao;
        this.accountDao = accountDao;
    }

    @Override
    public Customer save(Customer obj) {
        return customerDao.save(obj);
    }

    @Override
    public boolean delete(Customer obj) {
        return customerDao.delete(obj);
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        customerDao.deleteAll(entities);
    }

    @Override
    public void saveAll(List<Customer> entities) {
        customerDao.saveAll(entities);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.findAll();
    }

    @Override
    public boolean deleteById(long id) {
        return customerDao.deleteById(id);
    }

    @Override
    public Customer getById(long id) {
        return customerDao.getOne(id);
    }

    public Customer createCustomer(Customer customer) {
        return save(customer);
    }

    public Customer updatePersonalData(Customer incomingCustomer) {
        return customerDao.updateExisting(incomingCustomer);
    }

    public void createAccount(int customerId, String currency) {
        Customer newAccountOwner = getCustomerIfPreset(customerId);
        Account newAccount = new Account(Currency.valueOf(currency), newAccountOwner);
        newAccountOwner.getAccounts().add(newAccount);

        customerDao.updateExisting(newAccountOwner);
        accountDao.save(newAccount);
    }

    public void closeAccount(int customerId, int accountId) {
        Customer customer = getCustomerIfPreset(customerId);
        Account accountToClose = accountDao.getOne(accountId);
        customer.getAccounts().remove(accountToClose);

        customerDao.updateExisting(customer);
        accountDao.delete(accountToClose);
    }

    private Customer getCustomerIfPreset(int id) {
        if(getById(id) == null) {
            throw new RuntimeException();
        }
        return getById(id);
    }
}
