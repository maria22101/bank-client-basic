package com.example.bankclientbasic.dto;

import com.example.bankclientbasic.model.Currency;
import lombok.*;

@Data
public class AccountResponseDto {

    private Long id;

    private String number;

    private Currency currency;

    private Double balance;
}
