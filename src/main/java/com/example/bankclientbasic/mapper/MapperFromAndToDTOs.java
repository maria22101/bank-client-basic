package com.example.bankclientbasic.mapper;

import com.example.bankclientbasic.dto.*;
import com.example.bankclientbasic.model.Account;
import com.example.bankclientbasic.model.Customer;
import com.example.bankclientbasic.model.Employer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MapperFromAndToDTOs {

    @Autowired
    private ModelMapper mapper;

    public Customer toCustomerEntity(CustomerRequestDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Customer.class);
    }

    public CustomerResponseDto toCustomerDto(Customer entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, CustomerResponseDto.class);
    }

    public Account toAccountEntity(AccountRequestDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Account.class);
    }

    public AccountResponseDto toAccountDto(Account entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, AccountResponseDto.class);
    }

    public Employer toEmployerEntity(EmployerRequestDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Employer.class);
    }

    public EmployerResponseDto toEmployerDto(Employer entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, EmployerResponseDto.class);
    }
}
