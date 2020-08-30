package com.example.bankclientbasic.controller;

import com.example.bankclientbasic.dto.AccountRequestDto;
import com.example.bankclientbasic.dto.CustomerRequestDto;
import com.example.bankclientbasic.dto.CustomerResponseDto;
import com.example.bankclientbasic.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/{id}")
    public CustomerResponseDto getCustomerInfoById(@PathVariable int id) {
        return service.getCustomerResponseDtoById(id);
    }

    @GetMapping
    public List<CustomerResponseDto> getAllCustomersInfo() {
        return service.getAllCustomerResponseDTOs();
    }

    @PostMapping
    public CustomerResponseDto createCustomer(@Validated @RequestBody CustomerRequestDto dto) {
        return service.createCustomer(dto);
    }

    @PutMapping
    public CustomerResponseDto updateCustomerPersonalData(@Validated @RequestBody CustomerRequestDto dto) {
        return service.updateCustomerPersonalData(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable int id) {
        service.deleteById(id);
    }

    @PostMapping("/{id}/accounts")
    public void createAccount(@PathVariable int id,
                              @Validated @RequestBody AccountRequestDto dto) {
        service.createAccount(id, dto);
    }

    @DeleteMapping("/{customerId}/accounts/{accountNumber}")
    public void closeAccount(@PathVariable int customerId,
                             @PathVariable String accountNumber) {
        service.closeAccount(customerId, accountNumber);
    }
}

