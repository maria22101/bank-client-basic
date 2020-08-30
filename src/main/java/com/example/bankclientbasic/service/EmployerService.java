package com.example.bankclientbasic.service;

import com.example.bankclientbasic.model.Customer;
import com.example.bankclientbasic.model.Employer;
import com.example.bankclientbasic.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Service
public class EmployerService implements GeneralService<Employer> {

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public Employer save(Employer obj) {
        if (obj.getCreatedDate() == null) {
            obj.setCreatedDate(ZonedDateTime.now());
        }
        obj.setLastModifiedDate(ZonedDateTime.now());
        return employerRepository.save(obj);
    }

    @Override
    public boolean delete(Employer obj) {
        employerRepository.delete(obj);
        return true;
    }

    @Override
    public void deleteAll(List<Employer> entities) {
        employerRepository.deleteAll(entities);
    }

    @Override
    public void saveAll(List<Employer> entities) {
        employerRepository.saveAll(entities);
    }

    @Override
    public List<Employer> getAll() {
        return (List<Employer>) employerRepository.findAll();
    }

    @Override
    public boolean deleteById(long id) {
        employerRepository.deleteById(id);
        return true;
    }

    @Override
    public Employer getById(long id) {
        return employerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public Employer updateExisting(Employer updatedEmployer) {
        Employer existingEmployer = employerRepository.findById(updatedEmployer.getId())
                .orElseThrow(RuntimeException::new);
        updateExistingEmployerFields(updatedEmployer, existingEmployer);
        return employerRepository.save(existingEmployer);
    }

    private void updateExistingEmployerFields(Employer updatedEmployer, Employer existingEmployer) {
        existingEmployer.setCreatedDate(updatedEmployer.getCreatedDate());
        existingEmployer.setLastModifiedDate(ZonedDateTime.now());
        existingEmployer.setName(updatedEmployer.getName());
        existingEmployer.setAddress(updatedEmployer.getAddress());
    }
}
