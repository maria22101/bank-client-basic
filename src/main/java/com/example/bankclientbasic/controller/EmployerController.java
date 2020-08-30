package com.example.bankclientbasic.controller;

import com.example.bankclientbasic.model.Customer;
import com.example.bankclientbasic.model.Employer;
import com.example.bankclientbasic.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/v1/employers")
public class EmployerController {

    @Autowired
    private EmployerService service;

    @GetMapping("/{id}")
    public Employer getEmployerById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Employer> getAllEmployers() {
        return service.getAll();
    }

    @PostMapping
    public Employer createEmployer(@RequestBody Employer employer) {
        return service.save(employer);
    }

    @PutMapping
    public Employer updateEmployerInfo(@RequestBody Employer employer) {
        return service.updateExisting(employer);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployerById(@PathVariable int id) {
        service.deleteById(id);
    }

}
