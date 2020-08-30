package com.example.bankclientbasic.service;

import com.example.bankclientbasic.dto.EmployerRequestDto;
import com.example.bankclientbasic.dto.EmployerResponseDto;
import com.example.bankclientbasic.mapper.MapperFromAndToDTOs;
import com.example.bankclientbasic.model.Employer;
import com.example.bankclientbasic.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerService implements GeneralService<Employer> {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private MapperFromAndToDTOs mapper;

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

    public EmployerResponseDto getEmployerResponseDtoById(long id) {
        Employer employer = getById(id);
        return mapper.toEmployerDto(employer);
    }

    public List<EmployerResponseDto> getAllEmployerResponseDTOs() {
        List<Employer> allEmployers = getAll();
        return allEmployers.stream()
                .map(mapper::toEmployerDto)
                .collect(Collectors.toList());
    }

    public EmployerResponseDto createEmployer(EmployerRequestDto dto) {
        Employer employer = mapper.toEmployerEntity(dto);
        save(employer);
        return mapper.toEmployerDto(employer);
    }

    public EmployerResponseDto updateEmployerInfo(EmployerRequestDto dto) {
        Employer updatedEmployer = mapper.toEmployerEntity(dto);
        Employer existingEmployer = employerRepository
                .findEmployersByName(dto.getName())
                .orElseThrow(RuntimeException::new);
        updateExistingEmployerFields(updatedEmployer, existingEmployer);
        save(existingEmployer);
        return mapper.toEmployerDto(existingEmployer);
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
