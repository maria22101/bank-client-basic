package com.example.bankclientbasic.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
public class CustomerResponseDto {

    private Long id;

    private String name;

    private String email;

    private Integer age;

    @JsonIgnore
    private String password;

    private String phoneNumber;

    private List<AccountResponseDto> accounts;

    private Set<EmployerResponseDto> employers;
}
