package com.example.bankclientbasic.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CustomerRequestDto {

    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    private String email;

    @NotNull
    @Min(18)
    private Integer age;

    private String password;

    @Pattern(regexp = "((\\d{3})-(\\d{3}-\\d\\d-\\d\\d))")
    private String phoneNumber;
}
