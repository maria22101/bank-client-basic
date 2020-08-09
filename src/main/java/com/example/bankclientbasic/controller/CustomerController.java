package com.example.bankclientbasic.controller;

import com.example.bankclientbasic.model.Customer;
import com.example.bankclientbasic.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/v1/customers")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Customer getCustomerInfoById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomersInfo() {
        return service.getAll();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @PutMapping
    public Customer updateCustomerPersonalData(@RequestBody Customer customer) {
        return service.updatePersonalData(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable int id) {
        service.deleteById(id);
    }

    @PostMapping("/{id}/accounts")
    public void createAccount(@PathVariable int id,
                              @RequestParam String currency) {
        service.createAccount(id, currency);
    }

    @DeleteMapping("/{customerId}/accounts/{accountId}")
    public void closeAccount(@PathVariable int customerId,
                             @PathVariable int accountId) {
        service.closeAccount(customerId, accountId);
    }
}
