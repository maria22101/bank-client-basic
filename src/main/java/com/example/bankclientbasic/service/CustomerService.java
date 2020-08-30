package com.example.bankclientbasic.service;

import com.example.bankclientbasic.model.Account;
import com.example.bankclientbasic.model.Currency;
import com.example.bankclientbasic.model.Customer;
import com.example.bankclientbasic.repository.AccountRepository;
import com.example.bankclientbasic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class CustomerService implements GeneralService<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Customer save(Customer obj) {
        if (obj.getCreatedDate() == null) {
            obj.setCreatedDate(ZonedDateTime.now());
        }
        obj.setLastModifiedDate(ZonedDateTime.now());
        return customerRepository.save(obj);
    }

    @Override
    public boolean delete(Customer obj) {
        customerRepository.delete(obj);
        return true;
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        customerRepository.deleteAll(entities);
    }

    @Override
    public void saveAll(List<Customer> entities) {
        customerRepository.saveAll(entities);
    }

    @Override
    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public boolean deleteById(long id) {
        customerRepository.deleteById(id);
        return true;
    }

    @Override
    public Customer getById(long id) {
        return customerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public Customer updateExisting(Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(updatedCustomer.getId())
                .orElseThrow(RuntimeException::new);
        updateExistingCustomerFields(updatedCustomer, existingCustomer);
        return customerRepository.save(existingCustomer);
    }

    public void createAccount(int customerId, String currency) {
        Customer newAccountOwner = getById(customerId);
        Account newAccount = new Account(Currency.valueOf(currency), newAccountOwner);
        accountRepository.save(newAccount);
    }

    public void closeAccount(int customerId, int accountId) {
        accountRepository.deleteById((long) accountId);
    }

    private void updateExistingCustomerFields(Customer updatedCustomer, Customer existingCustomer) {
        existingCustomer.setCreatedDate(existingCustomer.getCreatedDate());
        existingCustomer.setLastModifiedDate(ZonedDateTime.now());
        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setAge(updatedCustomer.getAge());
        existingCustomer.setPassword(updatedCustomer.getPassword());
        existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
    }
}

