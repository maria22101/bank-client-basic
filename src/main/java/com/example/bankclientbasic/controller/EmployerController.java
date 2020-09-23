package com.example.bankclientbasic.controller;

import com.example.bankclientbasic.dto.EmployerRequestDto;
import com.example.bankclientbasic.dto.EmployerResponseDto;
import com.example.bankclientbasic.model.Customer;
import com.example.bankclientbasic.model.Employer;
import com.example.bankclientbasic.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/v1/employers")
public class EmployerController {

    @Autowired
    private EmployerService service;

    @GetMapping("/{id}")
    public EmployerResponseDto getEmployerById(@PathVariable int id) {
        return service.getEmployerResponseDtoById(id);
    }

    @GetMapping
    public List<EmployerResponseDto> getAllEmployers() {
        return service.getAllEmployerResponseDTOs();
    }

    @PostMapping
    public EmployerResponseDto createEmployer(@Validated @RequestBody EmployerRequestDto dto) {
        return service.createEmployer(dto);
    }

    @PutMapping
    public EmployerResponseDto updateEmployerInfo(@Validated @RequestBody EmployerRequestDto dto) {
        return service.updateEmployerInfo(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployerById(@PathVariable int id) {
        service.deleteById(id);
    }
}

