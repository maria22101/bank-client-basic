package com.example.bankclientbasic.service;

import com.example.bankclientbasic.dto.AccountRequestDto;
import com.example.bankclientbasic.dto.CustomerRequestDto;
import com.example.bankclientbasic.dto.CustomerResponseDto;
import com.example.bankclientbasic.mapper.MapperFromAndToDTOs;
import com.example.bankclientbasic.model.Account;
import com.example.bankclientbasic.model.Customer;
import com.example.bankclientbasic.repository.AccountRepository;
import com.example.bankclientbasic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements GeneralService<Customer> {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final MapperFromAndToDTOs mapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           AccountRepository accountRepository,
                           MapperFromAndToDTOs mapper) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.mapper = mapper;
    }

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

    public void createAccount(int customerId, AccountRequestDto dto) {
        Customer newAccountOwner = getById(customerId);
        Account newAccount = new Account(dto.getCurrency(), newAccountOwner, dto.getBalance());
        accountRepository.save(newAccount);
    }

    public void closeAccount(int customerId, String accountNumber) {
        Account account = accountRepository.findAccountsByNumber(accountNumber)
                .orElseThrow(RuntimeException::new);
        accountRepository.deleteById(account.getId());
    }

    public CustomerResponseDto getCustomerResponseDtoById(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return mapper.toCustomerDto(customer);
    }

    public List<CustomerResponseDto> getAllCustomerResponseDTOs() {
        List<Customer> allCustomers = getAll();
        return allCustomers.stream()
                .map(mapper::toCustomerDto)
                .collect(Collectors.toList());
    }

    public CustomerResponseDto createCustomer(CustomerRequestDto dto) {
        Customer customer = mapper.toCustomerEntity(dto);
        save(customer);
        return mapper.toCustomerDto(customer);
    }

    public CustomerResponseDto updateCustomerPersonalData(CustomerRequestDto dto) {
        Customer updatedCustomer = mapper.toCustomerEntity(dto);
        Customer existingCustomer = customerRepository
                .findCustomersByNameAndEmail(dto.getName(), dto.getEmail())
                .orElseThrow(RuntimeException::new);
        updateExistingCustomerFields(updatedCustomer, existingCustomer);
        save(existingCustomer);
        return mapper.toCustomerDto(existingCustomer);
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

