package com.example.bankclientbasic.repository;

import com.example.bankclientbasic.model.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface EmployerRepository extends CrudRepository<Employer, Long> {
    Optional<Employer> findEmployersByName(String name);
}
