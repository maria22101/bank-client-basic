package com.example.bankclientbasic.dto;

import com.example.bankclientbasic.model.Currency;
import lombok.*;

import javax.validation.constraints.*;

@Data
public class AccountRequestDto {

    @NotNull
    private Currency currency;

    @PositiveOrZero
    private Double balance;
}
